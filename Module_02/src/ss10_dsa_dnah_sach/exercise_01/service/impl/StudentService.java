package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Student;
import ss10_dsa_dnah_sach.exercise_01.service.IStudentService;
import utils.exception.PointException;
import utils.exception.exception.InvalidException;
import utils.exception.exception.InvalidStringException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class StudentService implements IStudentService {
    public static final String SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_STUDENT_CSV = "Module_02\\src\\ss10_dsa_dnah_sach\\exercise_01\\data\\student.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> arrStudent = new ArrayList<>();

    /**
     * thêm mới học sinh
     */
    @Override
    public void addStudent()  {
        Student student = this.infoStudent();
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(student);
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_STUDENT_CSV, true, convertListStudentToListString(studentsList));
        System.out.println("Thêm mới học sinh thành công");
    }


    /**
     * hiểm thị sinh viên
     */
    @Override
    public void displayAllStudent() {
        arrStudent = this.readFileStudent();
        for (Student x : arrStudent) {
            System.out.println(x.toString());
        }

    }

    /**
     * xoá sinh viên theo ID
     */
    @Override
    public void removeStudent() {
        arrStudent = this.readFileStudent();
        Student student = this.inputCheckID();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + student.getiD() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrStudent.remove(student);
                System.out.println("Xóa thành công!");
            }
        }
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_STUDENT_CSV, true, convertListStudentToListString(arrStudent));
    }

    /**
     * tìm kiếm sinh viên theo ID
     */
    public void searchID() {
        Student studentGetId = inputCheckID();
        if (studentGetId == null) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            System.out.println(studentGetId);
        }
    }

    /**
     * tìm kiếm sinh viên theo tên
     */
    public void searchName() {
        arrStudent = this.readFileStudent();
        List<Student> searchStudent = new ArrayList<>();
        System.out.print("Mời bạn nhập vào tên : ");
        String name = scanner.nextLine();
        for (Student student : arrStudent) {
            if (student.getName().contains(name)) {
                searchStudent.add(student);
            }
        }
        if (searchStudent.isEmpty()) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            for (Student student : searchStudent) {
                System.out.println(student.toString());

            }
        }
    }

    /**
     * sắp xếp sinh viên theo tên
     */
    public void sortReduceStudentName() {
        arrStudent = this.readFileStudent();
        boolean isSwap = true;
        for (int i = 0; i < arrStudent.size() - 1; i++) {
            isSwap = false;
            for (int j = i + 1; j < arrStudent.size(); j++) {
                if ((arrStudent.get(j).getName()).compareTo(arrStudent.get(i).getName()) > 0) {
                    Student tam = arrStudent.get(i);
                    arrStudent.set(i, arrStudent.get(j));
                    arrStudent.set(j, tam);
                    isSwap = true;
                }
            }
        }
        for (Student x : arrStudent) {
            System.out.println(x.toString());
        }
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_STUDENT_CSV, true, convertListStudentToListString(arrStudent));
    }

    /**
     * check ID nhập vào có tồn tại  trong mảng student
     *
     * @return vùng nhớ dữ liệu chưa iD nhập vào
     */
    public Student inputCheckID() {
        arrStudent = this.readFileStudent();
        System.out.print("Mời bạn nhập vào ID: ");
        String id = (scanner.nextLine());
        for (int i = 0; i < arrStudent.size(); i++) {
            if (arrStudent.get(i).getiD().equals(id)) {
                return arrStudent.get(i);
            }
        }
        return null;
    }

    /**
     * Nhập thông tin cho  student
     *
     * @return vùng nhớ dữ liệu student với cái thuộc tính cưa nhập
     */
    public Student infoStudent()  {
        String id = infoId();

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();

        String dateOfBirth = infoDateOfBirth();

        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();

        double point = infoPoint();

        return new Student(id, name, gender, dateOfBirth, nameClass, point);
    }

    /**
     * nhập thông tin ngày sinh
     *
     * @return ngày sinh
     */
    public String infoDateOfBirth() {
        String dateOfBirth;
        SimpleDateFormat formatter;
        Date DateOfBirthToDate;
        String dateNowString;
        int yearNow;
        int yearOfBirth;
        int age;

        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                if (dateOfBirth.equals("")) {
                    throw new InvalidStringException("Vui lòng nhập dữ liệu vào!");
                }
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false); // kiểm tra chặt chẽ hơn
                //được dụng để phân tích string thành date trong java.
                DateOfBirthToDate = formatter.parse(dateOfBirth);
                //được dụng để phân tích date nơ thành String trong java.
                dateNowString = formatter.format(new Date());
                yearNow = Integer.parseInt(dateNowString.substring(dateNowString.length() - 4));
                yearOfBirth = Integer.parseInt(dateOfBirth.substring(dateOfBirth.length() - 4));
                age = yearNow - yearOfBirth;
                if (age < 18 || age > 100) {
                    throw new InvalidException("Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn hoặc bằng 100");
                }
                return dateOfBirth;
            } catch (NumberFormatException e) {
                System.out.println("Ngày sinh chưa đúng định dạng dd/MM/yyyy. Nhập lại: ");
            } catch (ParseException e) {
                System.out.println("Bạn cần nhập đúng ngày tháng năm sinh . Nhập lại: ");
            } catch (InvalidException | InvalidStringException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * nhập thông tin ID
     *
     * @return ID
     */
    public String infoId() {
        String id = "";
        while (true) {
            System.out.print("Mời bạn nhập ID: ");
            id = scanner.nextLine();
            if (id.equals("")) {
                try {
                    throw new InvalidStringException("Vui lòng nhập lại ,bạn chưa nhập dữ liệu vào!");
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                }
            }
            return id;
        }

    }

    /**
     * nhập thông tin điểm
     *
     * @return trả về điểm
     */
    public double infoPoint() {
        double point ;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point > 100 || point < 0) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
                }
                return point;
            } catch (PointException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            }
        }
    }

    /**
     * đọc file danh sách student
     *
     * @return mảng mảng có các phần tử là các đối tượng student
     * @throws IOException
     */
    private List<Student> readFileStudent() {
        List<String> studentList = utils.read_write.ReadFile.readFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_STUDENT_CSV);
        List<Student> arrStudent = new ArrayList<>();
        if (studentList.size() == 0) {
            System.out.println("Dữ liệu trong file không có");
            return null;
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                String[] infoStudent = studentList.get(i).split(",");
                Student student = new Student(infoStudent[0], infoStudent[1], infoStudent[2], infoStudent[3], infoStudent[4], Double.parseDouble(infoStudent[5]));
                arrStudent.add(student);
            }
        }
        return arrStudent;
    }

    /**
     * chuyển mảng sudent có dữ liệu Student thành dữ liệu String
     *
     * @param studentList mảng có dữ liệu là Student
     * @return mảng các đối tượng studebt có dữ liệu là String
     */
    private List<String> convertListStudentToListString(List<Student> studentList) {
        List<String> stringsStudentList = new ArrayList<>();
        for (Student student : studentList) {
            stringsStudentList.add(student.toString());
        }
        return stringsStudentList;
    }
}
