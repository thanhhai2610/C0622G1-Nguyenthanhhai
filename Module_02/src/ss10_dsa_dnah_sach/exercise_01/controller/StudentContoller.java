package ss10_dsa_dnah_sach.exercise_01.controller;

import ss10_dsa_dnah_sach.exercise_01.service.IStudentService;
import ss10_dsa_dnah_sach.exercise_01.service.impl.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentContoller {

    private static Scanner scanner = new Scanner(System.in);
    private IStudentService studentService = new StudentService();

    public void menuManagementStudent() throws IOException {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Xóa sinh  viên");
            System.out.println("4. Tìm kiếm sinh  viên theo ID");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Exit");
            System.out.print("Mời bạn nhập chức năng 1-> 6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.displayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.removeStudent();
                    break;
                case 4:
                    studentService.searchID();
                    break;
                case 5:
                    studentService.searchName();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
