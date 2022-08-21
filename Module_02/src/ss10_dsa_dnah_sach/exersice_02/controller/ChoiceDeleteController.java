package ss10_dsa_dnah_sach.exersice_02.controller;

import ss10_dsa_dnah_sach.exersice_02.service.IVehicle;
import ss10_dsa_dnah_sach.exersice_02.service.impl.CarService;
import ss10_dsa_dnah_sach.exersice_02.service.impl.MotorService;
import ss10_dsa_dnah_sach.exersice_02.service.impl.TruckService;

import java.util.Scanner;

public class ChoiceDeleteController {
    private static Scanner scanner = new Scanner(System.in);
    private IVehicle carController = new CarService();
    private IVehicle motorController = new MotorService();
    private IVehicle truckController = new TruckService();

    public void menuMChoice(String value) {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1. " + value + " xe tải");
            System.out.println("2. " + value + " ô tô");
            System.out.println("3. " + value + " xe máy");
            System.out.println("4. Trở lại menu chính");
            System.out.print("Mời bạn nhập chức năng 1->3: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    truckController.remove();
                    break;
                case 2:
//                    carController.remove();
                    break;
                case 3:
//                    motorController.remove();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
