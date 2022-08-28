package casestudy_furama_resort_module_02.service.impl;

import casestudy_furama_resort_module_02.model.person.Employee;
import casestudy_furama_resort_module_02.service.IEmployeeService;
import utils.exception.check.ValidateId;
import utils.exception.check.ValiIEmployee.ValidateLevel;
import utils.exception.check.ValiIEmployee.ValidateLocation;
import utils.exception.exception.InvalidStringException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class EmployeeServiceImpl implements IEmployeeService {
    public static final String SRC_CASESTUDY_FURAMA_RESORT_MODULE_02_DATA_EMPLOYEE_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\employee.csv";
    Scanner scanner = new Scanner(System.in);
    List<Employee> employeelList = new ArrayList<>();
    InputInfoPeronServiceImpl inputInfoPeronService = new InputInfoPeronServiceImpl();

    @Override
    public void add() {
        Employee employeeAdd = this.infoEmployee("info");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeAdd);
        writeFile(SRC_CASESTUDY_FURAMA_RESORT_MODULE_02_DATA_EMPLOYEE_CSV, true, convertListEmployeeToListString(employeeList));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        employeelList = this.readFileEmployee();
        for (Employee x : employeelList) {
            System.out.println(x.toString());
        }
    }

    @Override
    public void update() {
        Employee employeeGetId = checkId(inputString("ID"));
        if (employeeGetId != null) {
            int idIndex = employeelList.indexOf(employeeGetId);
            Employee employeeUpdate = infoEmployee(employeeGetId.getId());
            System.out.println("Bạn có chắc muốn update đối tượng có ID là " + employeeGetId.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                employeelList.set(idIndex, employeeUpdate);
                writeFile(SRC_CASESTUDY_FURAMA_RESORT_MODULE_02_DATA_EMPLOYEE_CSV, false, convertListEmployeeToListString(employeelList));
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
    public Employee infoEmployee(String booleanId) {
        String infoID;
        if (booleanId.equals("info")) {
            infoID = infoId();
        } else {
            infoID = booleanId;
        }
        String infoLevel = infoLevel();
        String infoLocation = infoLocation();
        double infoSalary = infoSalary();
        return new Employee(infoID,
                inputInfoPeronService.infoName(),
                inputInfoPeronService.infoGender(),
                inputInfoPeronService.infoDateOfBirth(),
                Integer.parseInt(inputInfoPeronService.infoNumberIdentity()),
                Integer.parseInt(inputInfoPeronService.infoNumberPhone()),
                inputInfoPeronService.infoEmail(),
                infoLevel, infoLocation, infoSalary);
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
     * kiểm tra ID có tồn tại hay không
     *
     * @param idValue giá trị ID
     * @return trả vè đối tượng có ID trùng với ID nhập vào
     */
    public Employee checkId(String idValue) {
        employeelList = this.readFileEmployee();
        for (int i = 0; i < employeelList.size(); i++) {
            if (employeelList.get(i).getId().equals(idValue)) {
                return employeelList.get(i);
            }
        }
        return null;
    }


    /**
     * nhập thông tin ID
     *
     * @return ID
     */
    public String infoId() {
        ValidateId validateId = new ValidateId();
        String iD;
        while (true) {
            iD = inputString("ID");
            if (iD.equals("")) {
                continue;
            }
            if (validateId.validate(iD)) {
                return iD;
            } else {
                System.out.println("ID không đúng định dạng, vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập thông tin level
     *
     * @return level
     */
    public String infoLevel() {
        ValidateLevel validateLevel = new ValidateLevel();
        String level;
        while (true) {
            level = inputString("(Trung cấp, Cao đẳng, Đại học và sau Đại học)");
            if (level.equals("")) {
                continue;
            }
            if (validateLevel.validate(level)) {
                return level;
            } else {
                System.out.println("Bạn cần nhập theo quy định , vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập tông tin vị trí
     *
     * @return vị trí làm việc
     */
    public String infoLocation() {
        ValidateLocation validateLocation = new ValidateLocation();
        String location;
        while (true) {
            location = inputString("location: (Lễ tân, Phục vụ, Chuyên viên, Giám sát, Quản lý, Giám đốc)");
            if (location.equals("")) {
                continue;
            }
            if (validateLocation.validate(location)) {
                return location;
            } else {
                System.out.println("Bạn cần nhập local theo quy định , vui lòng nhập lại!");
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
     * chuyển mảng sudent có dữ liệu Student thành dữ liệu String
     *
     * @param employeeList mảng có dữ liệu là Student
     * @return mảng các đối tượng studebt có dữ liệu là String
     */
    private List<String> convertListEmployeeToListString(List<Employee> employeeList) {
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
    private List<Employee> readFileEmployee() {
        List<String> employeeArrString = null;
        List<Employee> employeeArr = new ArrayList<>();
        try {
            employeeArrString = utils.read_write.ReadFile.readFile(SRC_CASESTUDY_FURAMA_RESORT_MODULE_02_DATA_EMPLOYEE_CSV);
            if (employeeArrString.size() == 0) {
                System.out.println("Dữ liệu trong file không có");
            }
        } catch (NullPointerException e) {
            System.out.println("Dữ liệu trong file không có");
        }
        for (int i = 0; i < employeeArrString.size(); i++) {
            String[] infoEmployee = employeeArrString.get(i).split("=");
            Employee employee = new Employee(infoEmployee[0], infoEmployee[1], infoEmployee[2], infoEmployee[3], Integer.parseInt(infoEmployee[4]),
                    Integer.parseInt(infoEmployee[5]), infoEmployee[6], infoEmployee[7], infoEmployee[8], Double.parseDouble(infoEmployee[9]));
            employeeArr.add(employee);
        }
        return employeeArr;
    }
}
