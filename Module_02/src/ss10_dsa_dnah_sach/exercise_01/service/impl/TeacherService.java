package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Teacher;
import ss10_dsa_dnah_sach.exercise_01.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> arrTeacher = new ArrayList<>();

    static {
        arrTeacher.add(new Teacher(1, "HaiNT", "Nam", "26/10/1996", "Toán"));
        arrTeacher.add(new Teacher(1, "HaiTT", "Nữ", "12/12/1997", "Lý"));
    }


    @Override
    public void addTeacher() {
        arrTeacher.add(infoTeacher());
        System.out.println("Thêm mới giáo viên thành công");

    }

    @Override
    public void displayAllYTeacher() {
        for (Teacher x : arrTeacher) {
            System.out.println(x.toString());
        }

    }

    @Override
    public void removeTeacher() {


    }


    public Teacher infoTeacher() {
        System.out.print("Mời bạn nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn chuyên môn: ");
        String level = scanner.nextLine();

        return  new Teacher(id, name,gender, dateOfBirth, level);
    }


}
