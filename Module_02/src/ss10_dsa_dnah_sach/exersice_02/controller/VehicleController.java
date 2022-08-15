package ss10_dsa_dnah_sach.exersice_02.controller;

import java.util.Scanner;

public class VehicleController {
    private static Scanner scanner = new Scanner(System.in);
    private ChoiceAddController choiceAddController = new ChoiceAddController();
    private ChoiceDisplayController choiceDisplayController = new ChoiceDisplayController();
    private ChoiceDeleteController choiceDeleteController = new ChoiceDeleteController();
    private ChoiceSearchController choiceSearchController = new ChoiceSearchController();


    public void menuManagementVehicle() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với danh sách quản lý phương tiện");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiện thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5. Exit");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    choiceAddController.menuMChoice("Thêm");
                    break;
                case 2:
                    choiceDisplayController.menuMChoice("Hiển thị");
                    break;
                case 3:
                    choiceDeleteController.menuMChoice("Xoá");
                    break;
                case 4:
                    choiceSearchController.search();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }



}


