package ss10_dsa_dnah_sach.exercise_01.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class PersonController {
    private static Scanner scanner = new Scanner(System.in);
    //    DI
//    Nguyên lý D trong SOLID
    private StudentContoller studentContoller = new StudentContoller();
    private TeacherControllor teacherControllor = new TeacherControllor();

    public void managementPerson() throws IOException, ParseException {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Đến với tool giáo viên");
            System.out.println("2. Đến với tool học sinh");
            System.out.println("3. Exit");
            System.out.print("Mời bạn nhập chức năng 1-> 3: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    teacherControllor.menuManagementTeacher();
                    break;
                case 2:
                    studentContoller.menuManagementStudent();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

}
