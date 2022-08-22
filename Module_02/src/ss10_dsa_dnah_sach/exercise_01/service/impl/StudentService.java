package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Student;
import ss10_dsa_dnah_sach.exercise_01.service.IStudentService;
import ss10_dsa_dnah_sach.exercise_01.service.utils.PointException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> arrStudent = new ArrayList<>();

    static {
        arrStudent.add(new Student("1", "HaiNT", "NAM", "26/10/1996", "C0622G1", 9));
        arrStudent.add(new Student("2", "HaiTT", "Nu", "12/12/1997", "C0622G1", 9));
    }

    /**
     * thêm mới học sinh
     */
    @Override
    public void addStudent() throws IOException {
        String path = "Module_02\\src\\ss10_dsa_dnah_sach\\exercise_01\\data\\student.txt";
        List<Student> arrStudent = readFile(path);
        arrStudent.add(infoStudent());
        writeFile(arrStudent, path);
        System.out.println("Thêm mới học sinh thành công");
    }

    /**
     * viết mảng vừa được thêm phần tử vào file
     * @param arrStudent
     * @param path
     * @throws IOException
     */
    private static void writeFile(List<Student> arrStudent, String path) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : arrStudent) {
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * đọc file danh sách student
     * @param path
     * @return mảng mảng có các phần tử là đối tượng student
     * @throws IOException
     */
    private static List<Student> readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<Student> arrStudent = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Student student = new Student(info[0],info[1],info[2],info[3],info[4],Double.parseDouble(info[5]));
            arrStudent.add(student);
        }
        bufferedReader.close();
        return arrStudent;
    }

    /**
     * hiểm thị sinh viên
     */
    @Override
    public void displayAllStudent() {
        for (Student x : arrStudent) {
            System.out.println(x.toString());
        }
    }

    /**
     * xoá sinh viên theo ID
     */
    @Override
    public void removeStudent() {
        Student student = this.inputID();
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

    }

    /**
     * tìm kiếm sinh viên theo ID
     */
    public void searchID() {
        Student studentGetI = inputID();
        if (studentGetI == null) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            System.out.println(studentGetI);
        }
    }

    /**
     * tìm kiếm sinh viên theo tên
     */
    public void searchName() {
        Student studentGetI = inputName();
        if (studentGetI == null) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            System.out.println(studentGetI);
        }
    }

    /**
     * sắp xếp theo tên
     */
    public void sortReduceStudentName() {
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
    }

    /**
     * check tên nhập vào trong mảng student
     *
     * @return vùng nhớ dữ liệu có chưa tên nhập vào
     */
    public Student inputName() {
        System.out.print("Mời bạn nhập vào tên : ");
        String name = scanner.nextLine();
        for (int i = 0; i < arrStudent.size(); i++) {
            if (arrStudent.get(i).getName().contains(name)) {
                return arrStudent.get(i);
            }
        }
        return null;
    }

    /**
     * check ID nhập vào trong mảng student
     *
     * @return vùng nhớ dữ liệu chưa iD nhập vào
     */
    public Student inputID() {
        System.out.print("Mời bạn nhập vào id : ");
        String id = (scanner.nextLine());
        for (int i = 0; i < arrStudent.size(); i++) {
            if (arrStudent.get(i).getiD().equals(id)) {
                return arrStudent.get(i);
            }
        }
        return null;
    }

    /**
     * Nhập thông tin studet
     *
     * @return vùng nhớ dữ liệu stuet với cái thuộc tính cưa nhập
     */
    public Student infoStudent() {
        System.out.print("Mời bạn nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        double point = 0;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point > 100 || point < 0) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
                }
            } catch (PointException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");

            }

            System.out.print("Mời bạn nhập tên lớp: ");
            String nameClass = scanner.nextLine();
            return new Student(id, name, gender, dateOfBirth, nameClass, point);
        }
    }
}
