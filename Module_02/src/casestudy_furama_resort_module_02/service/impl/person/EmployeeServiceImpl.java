package casestudy_furama_resort_module_02.service.impl.person;

import casestudy_furama_resort_module_02.model.person.Employee;
import casestudy_furama_resort_module_02.model.person.Person;
import casestudy_furama_resort_module_02.service.IEmployeeService;
import utils.exception.exception.InvalidStringException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class EmployeeServiceImpl implements IEmployeeService {
    public static final String EMPLOYEE_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\employee.csv";
    Scanner scanner = new Scanner(System.in);
    private List<Employee> employeeList = new ArrayList<>();
    private InputInfoPeronServiceImpl inputInfoPeronService = new InputInfoPeronServiceImpl();

    @Override
    public void add() {
        Employee employeeAdd = this.infoEmployee("info");
        List<Employee> employeeListNew = new ArrayList<>();
        employeeListNew.add(employeeAdd);
        writeFile(EMPLOYEE_CSV, true, convertListEmployeeToListString(employeeListNew));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        employeeList = this.readFileEmployee();
        for (Employee x : employeeList) {
            System.out.println(x.toString());
        }
    }

    @Override
    public void update() {
        Employee employeeGetId = check(inputString("ID"), "ID");
        if (employeeGetId != null) {
            int idIndex = employeeList.indexOf(employeeGetId);
            Employee employeeUpdate = infoEmployee(employeeGetId.getId());
            System.out.println("Bạn có chắc muốn update đối tượng có ID là " + employeeGetId.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                employeeList.set(idIndex, employeeUpdate);
                writeFile(EMPLOYEE_CSV, false, convertListEmployeeToListString(employeeList));
                System.out.println("Update thành công!");
            }
        } else {
            System.out.println("Không tìm thấy đối tượng cần update");
        }
    }

    public void sort() {
        employeeList = this.readFileEmployee();
        employeeList.sort(Comparator.comparing(Person::getName));
        for (Employee x : employeeList) {
            System.out.println(x.toString());
        }
    }


    /**
     * Nhập thông tin nhân viên
     *
     * @param booleanId nếu là ìno thì phải nhập thông tin ID,không phải là info thì k cần nhập
     * @return trả về vùng nhớ cùa đối tượng có các thuộc tính
     */
    public Employee infoEmployee(String booleanId) {
        String infoID;
        if (booleanId.equals("info")) {
            infoID = inputInfoPeronService.infoId("Employee", "ID Employee ");
        } else {
            infoID = booleanId;
        }
        return new Employee(
                infoID,
                inputInfoPeronService.infoName(),
                inputInfoPeronService.infoGender(),
                inputInfoPeronService.infoDateOfBirth(),
                infoNumberPhone(),
                infoNumberIdentity(),
                inputInfoPeronService.infoEmail(),
                infoLevel(), infoLocation(), infoSalary());
    }

    /**
     * nhập thông tin level
     *
     * @return level
     */
    public String infoLevel() {
        while (true) {
            String level;
            System.out.println("Mời bạn chọn level\n" +
                    "1.\tTrung cấp\n" +
                    "2.\tCao đẳng\n" +
                    "3.\tĐại học\n" +
                    "4.\tSau Đại học\n");
            switch (choice()) {
                case 1:
                    return level = "Trung cấp";
                case 2:
                    return level = "Cao đẳng";
                case 3:
                    return level = "Đại học";
                case 4:
                    return level = "sau Đại học";
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
    public String infoLocation() {
        while (true) {
            String location;
            System.out.println("Mời bạn chọn location\n" +
                    "1.\tLễ tân\n" +
                    "2.\tPhục vụ\n" +
                    "3.\tChuyên viên\n" +
                    "4.\tGiám sát\n" +
                    "5.\tQuản lý\n" +
                    "6.\tGiám đốc\n");
            switch (choice()) {
                case 1:
                    return location = "Lễ tân";
                case 2:
                    return location = "Phục vụ";
                case 3:
                    return location = "Chuyên viên";
                case 4:
                    return location = "Giám sát";
                case 5:
                    return location = "Quản lý";
                case 6:
                    return location = "Giám đốc";
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

    /**
     * nhập thông tin lương
     *
     * @return thông tin lương
     */
    public double infoSalary() {
        double salary;
        while (true) {
            try {
                System.out.print("Mời bạn nhập salary : ");
                salary = Double.parseDouble(scanner.nextLine());
                return salary;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            }
        }
    }


    /**
     * check giá trị nhập (inputValue) vào không đc để rỗng
     *
     * @param inputString có thể là ID, name ,,, bất kì cái nào nhập vào là chuỗi
     * @return tả về giá trị nhập vào cho các thuộc tính
     */
    public String inputString(String inputString) {
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
     * kiểm tra (ID, NumberIdentity, NumberIdentity) có tồn tại hay không
     *
     * @param Value giá trị (ID, NumberIdentity, NumberIdentity)
     * @return trả vè đối tượng có (ID, NumberIdentity, NumberIdentity) trùng với (ID, NumberIdentity, NumberIdentity) nhập vào
     */
    public Employee check(String Value, String what) {
        employeeList = this.readFileEmployee();
        for (int i = 0; i < employeeList.size(); i++) {
            if (what.equals("ID") && employeeList.get(i).getId().equals(Value)) {
                return employeeList.get(i);
            }
            if (what.equals("NumberIdentity") && employeeList.get(i).getNumberIdentity().equals(Value)) {
                return employeeList.get(i);
            }
            if (what.equals("NumberPhone") && employeeList.get(i).getNumberPhone().equals(Value)) {
                return employeeList.get(i);
            }
        }
        return null;
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
     * @param employeeList mảng có dữ liệu là Student
     * @return mảng các đối tượng studebt có dữ liệu là String
     */
    public List<String> convertListEmployeeToListString(List<Employee> employeeList) {
        List<String> stringsEmployeeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringsEmployeeList.add(employee.toString());
        }
        return stringsEmployeeList;
    }

    /**
     * đọc file danh sách student
     *
     * @return mảng mảng có các phần tử là các đối tượng student
     * @throws IOException
     */
    public List<Employee> readFileEmployee() {
        List<String> employeeArrString = null;
        List<Employee> employeeArr = new ArrayList<>();
        try {
            employeeArrString = utils.read_write.ReadFile.readFile(EMPLOYEE_CSV);
            if (employeeArrString.size() == 0) {
                System.out.println("Dữ liệu trong file không có");
            }
        } catch (NullPointerException e) {
            System.out.println("Dữ liệu trong file không có");
        }
        for (int i = 0; i < employeeArrString.size(); i++) {
            String[] infoEmployee = employeeArrString.get(i).split("=");
            Employee employee = new Employee(infoEmployee[0], infoEmployee[1], infoEmployee[2], infoEmployee[3], infoEmployee[4],
                    infoEmployee[5], infoEmployee[6], infoEmployee[7], infoEmployee[8], Double.parseDouble(infoEmployee[9]));
            employeeArr.add(employee);
        }
        return employeeArr;
    }
}
