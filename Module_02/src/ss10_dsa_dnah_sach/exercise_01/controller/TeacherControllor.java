package ss10_dsa_dnah_sach.exercise_01.controller;

import ss10_dsa_dnah_sach.exercise_01.service.ITeacherService;
import ss10_dsa_dnah_sach.exercise_01.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class TeacherControllor {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherService teacherService = new TeacherService();

    public void menuManagementTeacher() throws IOException {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Xem danh sách giáo viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Xóa giáo viên");
            System.out.println("4. Tìm kiếm giáo viên thoe ID");
            System.out.println("5. Tìm kiếm giáo viên tên");
            System.out.println("6. Sắp xếp giáo viên ");
            System.out.println("7. Exit");
            System.out.print("Mời bạn nhập chức năng 1-> 6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherService.displayAllYTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.removeTeacher();
                    break;
                case 4:
                    teacherService.searchID();
                    break;
                case 5:
                    teacherService.searchName();
                    break;
                case 6:
                    teacherService.sortReduceTeacherName();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
