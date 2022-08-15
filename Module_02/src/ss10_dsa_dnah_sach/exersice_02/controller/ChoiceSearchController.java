package ss10_dsa_dnah_sach.exersice_02.controller;

import ss10_dsa_dnah_sach.exersice_02.model.Vehicle;
import ss10_dsa_dnah_sach.exersice_02.service.impl.CarService;
import ss10_dsa_dnah_sach.exersice_02.service.impl.MotorService;
import ss10_dsa_dnah_sach.exersice_02.service.impl.TruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceSearchController {
    private static Scanner scanner = new Scanner(System.in);
    private CarService carController = new CarService();
    private MotorService motorController = new MotorService();
    private TruckService truckController = new TruckService();
    private static List<Vehicle> arr = new ArrayList<>();

    public void addAray() {
        carController.addArr(arr);
        motorController.addArr(arr);
        truckController.addArr(arr);
    }

    public void search() {
            Vehicle vehicle = this.check(" mời bạn nhập vào biển kiểm xoát cần tim kiếm ");
            if (vehicle == null) {
                System.out.println("Không tìm thấy phương tiện cần tìm");
            } else {
                System.out.println(vehicle.toString());
            }
    }

    public Vehicle check(String notification) {
        addAray();
        System.out.print(notification);
        String licensePlates = scanner.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getLicensePlates().equals(licensePlates)) {
                return arr.get(i);
            }
        }
        return null;
    }
}
