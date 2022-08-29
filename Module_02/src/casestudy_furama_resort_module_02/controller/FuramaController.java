package casestudy_furama_resort_module_02.controller;

import casestudy_furama_resort_module_02.service.impl.facility.FacilityServiceImpl;
import casestudy_furama_resort_module_02.service.impl.person.CustomerServiceImpl;
import casestudy_furama_resort_module_02.service.impl.person.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl(); //Tạo đối tượng EmployeeServiceImpl trong FuramaController
    CustomerServiceImpl customerService = new CustomerServiceImpl(); //Tạo đối tượng EmployeeServiceImpl trong FuramaController
    FacilityServiceImpl facilityService = new FacilityServiceImpl(); //Tạo đối tượng EmployeeServiceImpl trong FuramaController

    public void displayMainMenu() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với Furama");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            switch (choice()) {
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
     * Management cho phép cọn các chức năng CRUD cho Employee
     */
    public void employeeManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với EmployeeManagement");
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            switch (choice()) {
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

    /**
     * Management cho phép cọn các chức năng CRUD cho Customer
     */
    public void customerManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với CustomerManagement");
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            switch (choice()) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.update();
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
            System.out.println("Chào mừng bạn đến với FacilityManagement");
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            switch (choice()) {
                case 1:
                    facilityService.displayFacility();
                    break;
                case 2:
                    facilityManagementAdd();
                    break;
                case 3:
                    facilityService.displayFacilityMaintenance();
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
            System.out.println("Chào mừng bạn đến với Booking");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6 Return main menu");
            switch (choice()) {
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
            System.out.println("Chào mừng bạn đến với Promotion");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            switch (choice()) {
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

    public void facilityManagementAdd() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n");
            switch (choice()) {
                case 1:
                    facilityService.addVilla();
                    break;
                case 2:
                    facilityService.addHouse();
                    break;
                case 3:
                    facilityService.addRoom();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

    public int choice() {
        int choice;
        while (true) {
            try {
                System.out.print("Mời bạn nhập các chức năng : ");
                choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            }
        }
    }

}
