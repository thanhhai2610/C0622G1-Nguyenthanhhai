package ss10_dsa_dnah_sach.exersice_02.service.impl;

import ss10_dsa_dnah_sach.exersice_02.model.Truck;
import ss10_dsa_dnah_sach.exersice_02.model.Vehicle;
import ss10_dsa_dnah_sach.exersice_02.service.IVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements IVehicle {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Vehicle> arrayTruck = new ArrayList<>();


    static {
        arrayTruck.add(new Truck("555555555", "Honda", 1999, "Nguyễn Thanh Hải", 1.5));
        arrayTruck.add(new Truck("666666666", "Vinfast", 1999, "Nguyễn Thanh Hải", 1.5));

    }

    @Override
    public void add() {
        Vehicle tam1=infoTruck();
        String tam = tam1.getLicensePlates();
        for (int i = 0; i < arrayTruck.size(); i++) {
            if (arrayTruck.get(i).getLicensePlates().equals(tam)) {
                System.out.println("Biển số bị trùng");
                return;
            }
        }
        arrayTruck.add(tam1);
        System.out.println("Thêm mới xe thành công");
    }

    public void addArr(List<Vehicle> arr) {
        for (Vehicle x : arrayTruck) {
            arr.add(x);

        }
    }

    @Override
    public void display() {
        for (Vehicle x : arrayTruck) {
            System.out.println(x.toString());
        }
    }



    @Override
    public void removeByLicensePlates() {
        Vehicle truck = this.input("Mời bạn nhập vào biển kiểm xoát  cần xóa: ");
        if (truck == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có biểm kiểm xoát là " + truck.getLicensePlates() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrayTruck.remove(truck);
                System.out.println("Xóa thành công!");
            }
        }

    }

    public Vehicle input(String notification) {
        System.out.print(notification);
        String licensePlates = scanner.nextLine();
        for (int i = 0; i < arrayTruck.size(); i++) {
            if (arrayTruck.get(i).getLicensePlates().equals(licensePlates)) {
                return arrayTruck.get(i);
            }
        }
        return null;
    }

    public Vehicle infoTruck() {
        System.out.print("Mời bạn nhập BIển kiểm xoát: ");
        String licensePlates = scanner.nextLine();

        System.out.print("Mời bạn nhập HÃng xe: ");
        String nameBrand = scanner.nextLine();

        System.out.print("Mời bạn nhập Năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập Chủ sở hưu: ");
        String owner = scanner.nextLine();

        System.out.print("Mời bạn nhập Tải trọng xe: ");
        int tonnager = Integer.parseInt(scanner.nextLine());

        return new Truck(licensePlates, nameBrand, yearManufacture, owner, tonnager);
    }

}
