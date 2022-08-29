package text.main_CRUD;

import casestudy_furama_resort_module_02.service.impl.person.EmployeeServiceImpl;

public class display_employee {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.display();
    }
}
