package casestudy_furama_resort_module_02.controller;

import casestudy_furama_resort_module_02.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    EmployeeServiceImpl employeeService =new EmployeeServiceImpl(); //Tạo đối tượng EmployeeServiceImpl trong FuramaController
    public void displayMainMenu() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6.  Exit");
            System.out.print("Mời bạn nhập chức năng 1-> 4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                   bookingManagement();
                    break;
                case 5:
                    promotionManagement();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }

    }

    /**
     *  Management cho phép cọn các chức năng CRUD cho Employee
     */
    public void employeeManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với EmployeeManagement");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.print("Mời bạn nhập chức năng 1-> 4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.update();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

    public void customerManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với CustomerManagement");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4 Return main menu");
            System.out.print("Mời bạn nhập chức năng 1-> 4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }

    }

    public void facilityManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Edit facility");
            System.out.println("4 Return main menu");
            System.out.print("Mời bạn nhập chức năng 1-> 4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

    public void bookingManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6 Return main menu");
            System.out.print("Mời bạn nhập chức năng 1-> 4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }

    }

    public void promotionManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Codegym");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.print("Mời bạn nhập chức năng 1-> 3: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }


}
