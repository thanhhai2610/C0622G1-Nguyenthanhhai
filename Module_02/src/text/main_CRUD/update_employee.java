package text.main_CRUD;

import casestudy_furama_resort_module_02.service.impl.person.EmployeeServiceImpl;

public class update_employee {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.update();
    }
}
