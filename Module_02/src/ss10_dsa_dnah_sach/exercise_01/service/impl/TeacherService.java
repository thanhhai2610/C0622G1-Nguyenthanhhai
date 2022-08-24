package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Teacher;
import ss10_dsa_dnah_sach.exercise_01.service.ITeacherService;
import utils.exception.InvalidStringException;
import utils.read_write_file.ReadFileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class TeacherService implements ITeacherService {
    public static final String SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_TEACHER_CSV = "Module_02\\src\\ss10_dsa_dnah_sach\\exercise_01\\data\\teacher.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> arrTeacher = new ArrayList<>();

    /**
     * Thêm mới giáo viên
     */
    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        List<Teacher> teachersList = new ArrayList<>();
        teachersList.add(teacher);
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_TEACHER_CSV, false, convertListTeacherToListString(teachersList));
        System.out.println("Thêm mới học sinh thành công");
    }


    /**
     * hiểm thị all giáo viên
     */
    @Override
    public void displayAllYTeacher() {
        arrTeacher = this.readFileTeacher();
        for (Teacher x : arrTeacher) {
            System.out.println(x.toString());
        }
    }


    /**
     * xoá giáo viên theo ID
     */
    @Override
    public void removeTeacher() {
        arrTeacher = this.readFileTeacher();
        Teacher teacher = this.inputCheckID();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getiD() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrTeacher.remove(teacher);
                System.out.println("Xóa thành công!");
            }
        }
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_TEACHER_CSV, false, convertListTeacherToListString(arrTeacher));
    }

    /**
     * tìm kiếm giáo viên theo ID
     */
    public void searchID() {
        Teacher teacherGetId = inputCheckID();
        if (teacherGetId == null) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            System.out.println(teacherGetId);
        }
    }

    /**
     * tiềm kiếm giáo viên theo tên
     */
    public void searchName() {
        arrTeacher = this.readFileTeacher();
        List<Teacher> searchTeacher = new ArrayList<>();
        System.out.print("Mời bạn nhập vào tên : ");
        String name = scanner.nextLine();
        for (Teacher teacher : arrTeacher) {
            if (teacher.getName().contains(name)) {
                searchTeacher.add(teacher);
            }
        }
        if (searchTeacher.isEmpty()) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            for (Teacher teacher : searchTeacher) {
                System.out.println(teacher.toString());

            }
        }
    }

    /**
     * sắp xếo giáo viên theo tên
     */
    public void sortReduceTeacherName() {
        arrTeacher = this.readFileTeacher();
        boolean isSwap = true;
        for (int i = 0; i < arrTeacher.size() - 1; i++) {
            isSwap = false;
            for (int j = i + 1; j < arrTeacher.size(); j++) {
                if ((arrTeacher.get(j).getName()).compareTo(arrTeacher.get(i).getName()) > 0) {
                    Teacher tam = arrTeacher.get(i);
                    arrTeacher.set(i, arrTeacher.get(j));
                    arrTeacher.set(j, tam);
                    isSwap = true;
                }
            }
        }
        for (Teacher x : arrTeacher) {
            System.out.println(x.toString());
        }
        writeFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_TEACHER_CSV, false, convertListTeacherToListString(arrTeacher));
    }

    /**
     * check ID nhập vào
     *
     * @return vùng hớ dữ liệu có chưa ID nhập vào
     */
    public Teacher inputCheckID() {
        arrTeacher = this.readFileTeacher();
        System.out.print("Mời bạn nhập vào ID : ");
        String id = (scanner.nextLine());
        for (int i = 0; i < arrTeacher.size(); i++) {
            if (arrTeacher.get(i).getiD().equals(id)) {
                return arrTeacher.get(i);
            }
        }
        return null;
    }

    /**
     * Nhập thông tin cho giáo viên
     *
     * @return vùng nhớ chưa thông tin giáo viên
     */
    public Teacher infoTeacher() {
        String id = infoId();



        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn chuyên môn: ");
        String level = scanner.nextLine();

        return new Teacher(id, name, gender, dateOfBirth, level);
    }

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
     * đọc file danh sách teacher
     *
     * @return mảng mảng có các phần tử là các đối tượng teacher
     * @throws IOException
     */
    private List<Teacher> readFileTeacher() {
        List<String> teacherList = ReadFileUtil.readFile(SS_10_DSA_DNAH_SACH_EXERCISE_01_DATA_TEACHER_CSV);
        List<Teacher> arrTeacher = new ArrayList<>();
        if (teacherList.size() == 0) {
            System.out.println("Dữ liệu trong file không có");
            return null;
        } else {
            for (int i = 0; i < teacherList.size(); i++) {
                String[] infoTeacher = teacherList.get(i).split(",");
                Teacher teacher = new Teacher(infoTeacher[0], infoTeacher[1], infoTeacher[2], infoTeacher[3], infoTeacher[4]);
                arrTeacher.add(teacher);
            }
        }
        return arrTeacher;
    }

    /**
     * chuyển mảng teacher có dữ liệu Teacher thành dữ liệu String
     *
     * @param teachersList mảng có dữ liệu là Teacher
     * @return mảng các đối tượng teacher có dữ liệu là String
     */
    private List<String> convertListTeacherToListString(List<Teacher> teachersList) {
        List<String> stringsTeachertList = new ArrayList<>();
        for (Teacher teacher : teachersList) {
            stringsTeachertList.add(teacher.toString());
        }
        return stringsTeachertList;
    }

}
