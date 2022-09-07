package casestudy_furama_resort_module_02.service.impl.person;

import casestudy_furama_resort_module_02.model.person.Customer;
import casestudy_furama_resort_module_02.service.ICustomerService;
import utils.exception.exception.InvalidStringException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class CustomerServiceImpl implements ICustomerService {
    public static final String CUSTOMER_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\customer.csv";
    Scanner scanner = new Scanner(System.in);
    InputInfoPeronServiceImpl inputInfoPeronService = new InputInfoPeronServiceImpl();
    List<Customer> customerList = new LinkedList<>();

    @Override
    public void add() {
        Customer customerAdd = this.infoCustomer("info");
        List<Customer> customerList = new LinkedList<>();
        customerList.add(customerAdd);
        writeFile(CUSTOMER_CSV, true, convertListCustomerToListString(customerList));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        customerList = this.readFileCustomer();
        for (Customer x : customerList) {
            System.out.println(x.toString());
        }
    }

    @Override
    public void update() {
        Customer customerGetId = checkId(inputString("ID"));
        if (customerGetId != null) {
            int idIndex = customerList.indexOf(customerGetId);
            Customer employeeUpdate = infoCustomer(customerGetId.getId());
            System.out.println("Bạn có chắc muốn update đối tượng có ID là " + customerGetId.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                customerList.set(idIndex, employeeUpdate);
                writeFile(CUSTOMER_CSV, false, convertListCustomerToListString(customerList));
                System.out.println("Update thành công!");
            }
        } else {
            System.out.println("Không tìm thấy đối tượng cần update");
        }
    }

    /**
     * Nhập thông tin nhân viên
     *
     * @param booleanId nếu là ìno thì phải nhập thông tin ID,không phải là info thì k cần nhập
     * @return trả về vùng nhớ cùa đối tượng có các thuộc tính
     */
    public Customer infoCustomer(String booleanId) {
        customerList = this.readFileCustomer();
        String infoID;
        if (booleanId.equals("info")) {
            infoID = inputInfoPeronService.infoId("Customer", "ID Customer");
        } else {
            infoID = booleanId;
        }
        return new Customer(infoID,
                inputInfoPeronService.infoName(),
                inputInfoPeronService.infoGender(),
                inputInfoPeronService.infoDateOfBirth(),
                infoNumberIdentity(),
                infoNumberPhone(),
                inputInfoPeronService.infoEmail(),
                infoGuestType(), infoAddress());
    }

    public String infoNumberPhone() {
        while (true) {
            try {
                if (check(inputInfoPeronService.infoNumberPhone(), "NumberPhone") != null) {
                    throw new NumberFormatException();
                }
                return inputInfoPeronService.infoNumberPhone();
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập bị trùng số điện thoại. Yêu cầu nhập lại.");
            }
        }
    }

    public String infoNumberIdentity() {
        while (true) {
            try {
                if (check(inputInfoPeronService.infoNumberIdentity(), "NumberIdentity") != null) {
                    throw new Exception();
                }
                return inputInfoPeronService.infoNumberPhone();
            } catch (Exception e) {
                System.out.println("Bạn nhập bị trùng số điện thoại. Yêu cầu nhập lại.");
            }
        }
    }

    public Customer check(String Value, String what) {
        customerList = this.readFileCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if (what.equals("ID") && customerList.get(i).getId().equals(Value)) {
                return customerList.get(i);
            }
            if (what.equals("NumberIdentity") && customerList.get(i).getNumberIdentity().equals(Value)) {
                return customerList.get(i);
            }
            if (what.equals("NumberPhone") && customerList.get(i).getNumberPhone().equals(Value)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    /**
     * nhập thông tin GuestType
     *
     * @return GuestType
     */
    public String infoGuestType() {
        while (true) {
            String guestType;
            System.out.println("Mời bạn chọn guestType\n" +
                    "1.\tDiamond\n" +
                    "2.\tPlatinum\n" +
                    "3.\tGold\n" +
                    "3.\tSilver\n" +
                    "4.\tMember\n");
            switch (choice()) {
                case 1:
                    return guestType = "Diamond";
                case 2:
                    return guestType = "Platinum";
                case 3:
                    return guestType = "Gold";
                case 4:
                    return guestType = "Silver";
                case 5:
                    return guestType = "Member";
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

    /**
     * nhập tông tin vị trí
     *
     * @return vị trí làm việc
     */
    public String infoAddress() {
        String address;
        while (true) {
            address = inputString("address");
            if (address.equals("")) {
                continue;
            }
            return address;
        }
    }

    /**
     * check giá trị nhập (inputValue) vào không đc để rỗng
     *
     * @param inputString có thể là ID, name ,,, bất kì cái nào nhập vào là chuỗi
     * @return tả về giá trị nhập vào cho các thuộc tính
     */
    private String inputString(String inputString) {
        String inputValue;
        while (true) {
            System.out.print("Mời bạn nhập " + inputString + " : ");
            inputValue = scanner.nextLine();
            if (inputValue.equals("")) {
                try {
                    throw new InvalidStringException("Vui lòng nhập lại ,bạn chưa nhập dữ liệu vào!");
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                }
            }
            return inputValue;
        }
    }

    /**
     * kiểm tra ID có tồn tại hay không
     *
     * @param idValue giá trị ID
     * @return trả vè đối tượng có ID trùng với ID nhập vào
     */
    private Customer checkId(String idValue) {
        customerList = this.readFileCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(idValue)) {
                return customerList.get(i);
            }
        }
        return null;
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

    /**
     * chuyển mảng sudent có dữ liệu Student thành dữ liệu String
     *
     * @param customerList mảng có dữ liệu là Student
     * @return mảng các đối tượng studebt có dữ liệu là String
     */
    private List<String> convertListCustomerToListString(List<Customer> customerList) {
        List<String> stringsEmployeeList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringsEmployeeList.add(customer.toString());
        }
        return stringsEmployeeList;
    }

    /**
     * đọc file danh sách student
     *
     * @return mảng mảng có các phần tử là các đối tượng student
     * @throws IOException
     */
    public List<Customer> readFileCustomer() {
        List<Customer> customersArr = new ArrayList<>();
        List<String> customerArrString = null;
        try {
            customerArrString = utils.read_write.ReadFile.readFile(CUSTOMER_CSV);
            if (customerArrString.size() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Dữ liệu trong file không có");
        }
        for (int i = 0; i < customerArrString.size(); i++) {
            String[] infoCustomer = customerArrString.get(i).split("=");
            Customer customer = new Customer(infoCustomer[0], infoCustomer[1], infoCustomer[2],
                    infoCustomer[3], infoCustomer[4],
                    (infoCustomer[5]), infoCustomer[6],
                    infoCustomer[7], infoCustomer[8]);
            customersArr.add(customer);
        }
        return customersArr;
    }
}
