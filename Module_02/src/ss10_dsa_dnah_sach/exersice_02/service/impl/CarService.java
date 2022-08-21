package ss10_dsa_dnah_sach.exersice_02.service.impl;

import ss10_dsa_dnah_sach.exersice_02.model.Car;
import ss10_dsa_dnah_sach.exersice_02.model.Vehicle;
import ss10_dsa_dnah_sach.exersice_02.service.IVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements IVehicle {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Vehicle> arraycar = new ArrayList<>();

    static {
        arraycar.add(new Car("333333333", "Honda", 2022, "Nguyễn Thanh Hải", 16, "Xe du lich"));
        arraycar.add(new Car("444444444", "Vinfast", 2022, "Nguyễn Thanh Hải", 4, "Xe gia oto 4 gia đình"));
    }

    /**
     * thêm xe mới
     */
    @Override
    public void add() {
        Vehicle tam1=infoCar();
        String tam = tam1.getLicensePlates();
        for (int i = 0; i < arraycar.size(); i++) {
            if (arraycar.get(i).getLicensePlates().equals(tam)) {
                System.out.println("Biển số bị trùng");
                return;
            }
        }
        arraycar.add(tam1);
        System.out.println("Thêm mới xe thành công");
    }

    /**
     * thêm mảng arrCar vào mảng cha (Vehicle)
     * @param arr "tham sô đầu vào là một mảng cha (vehicle)"
     */
    public void addArr(List<Vehicle> arr) {
        for (Vehicle x : arraycar) {
            arr.add(x);
        }
    }

    /**
     * hiển thị car
     */
    @Override
    public void display() {
        for (Vehicle x : arraycar) {
            System.out.println(x.toString());
        }
    }

    /**
     * xoá một đối tượng car theo BKS
     */
    @Override
    public void removeByLicensePlates() {
        Vehicle car = this.input("Mời bạn nhập vào biển kiểm xoát  cần xóa: ");
        if (car == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có biểm kiểm xoát là " + car.getLicensePlates() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arraycar.remove(car);
                System.out.println("Xóa thành công!");
            }
        }

    }

    /**
     * check giá trị thuộc tính nhập vào có sẵn chưa
     * @param notification
     * @return vùng nhớ chưa giá trị thuộc tính nhập
     */
    public Vehicle input(String notification) {
        System.out.print(notification);
        String licensePlates = scanner.nextLine();
        for (int i = 0; i < arraycar.size(); i++) {
            if (arraycar.get(i).getLicensePlates().equals(licensePlates)) {
                return arraycar.get(i);
            }
        }
        return null;
    }

    /**
     * Nhập thông tin Car
     * @return vùng nhớ dối tương car mới có thông tin mới nhập vào
     */
    public Vehicle infoCar() {
        System.out.print("Mời bạn nhập BIển kiểm xoát: ");
        String licensePlates = scanner.nextLine();

        System.out.print("Mời bạn nhập HÃng xe: ");
        String nameBrand = scanner.nextLine();

        System.out.print("Mời bạn nhập Năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập Chủ sở hưu: ");
        String owner = scanner.nextLine();

        System.out.print("Mời bạn nhập số chỗ xe: ");
        int numberSeats = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập loại xe: ");
        String vehicleType = scanner.nextLine();

        return new Car(licensePlates, nameBrand, yearManufacture, owner, numberSeats, vehicleType);
    }
}
