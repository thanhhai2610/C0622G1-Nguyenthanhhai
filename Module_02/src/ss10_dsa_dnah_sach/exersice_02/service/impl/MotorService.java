package ss10_dsa_dnah_sach.exersice_02.service.impl;

import ss10_dsa_dnah_sach.exersice_02.model.Motor;
import ss10_dsa_dnah_sach.exersice_02.model.Vehicle;
import ss10_dsa_dnah_sach.exersice_02.service.IVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorService implements IVehicle {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Vehicle> arrayMotor = new ArrayList<>();


    static {
        arrayMotor.add(new Motor("111111111", "Honda", 2022, "Nguyễn Thanh Hải", 150));
        arrayMotor.add(new Motor("222222222", "Vinfast", 2022, "Nguyễn Thanh Hải", 150));

    }

    @Override
    public void add() {
        arrayMotor.add(infoMotor());
        System.out.println("Thêm mới xe thành công");
    }
    public void addArr(List<Vehicle> arr) {
        for (Vehicle x : arrayMotor) {
            arr.add(x);
        }
    }

    @Override
    public void display() {
        for (Vehicle x : arrayMotor) {
            System.out.println(x.toString());
        }
    }

    @Override
    public void remove() {
        Vehicle motor = this.input("Mời bạn nhập vào biển kiểm xoát  cần xóa: ");
        if (motor == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có biểm kiểm xoát là " + motor.getLicensePlates() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrayMotor.remove(motor);
                System.out.println("Xóa thành công!");
            }
        }

    }


    public Vehicle input(String notification) {
        System.out.print(notification);
        String licensePlates = scanner.nextLine();
        for (int i = 0; i < arrayMotor.size(); i++) {
            if (arrayMotor.get(i).getLicensePlates().equals(licensePlates)) {
                return arrayMotor.get(i);
            }
        }
        return null;
    }

    public Vehicle infoMotor() {
        System.out.print("Mời bạn nhập BIển kiểm xoát: ");
        String licensePlates = scanner.nextLine();

        System.out.print("Mời bạn nhập HÃng xe: ");
        String nameBrand = scanner.nextLine();

        System.out.print("Mời bạn nhập Năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập Chủ sở hưu: ");
        String owner = scanner.nextLine();

        System.out.print("Mời bạn nhập công suất xe: ");
        int wattage = Integer.parseInt(scanner.nextLine());

        return new Motor(licensePlates, nameBrand, yearManufacture, owner, wattage);
    }
}
