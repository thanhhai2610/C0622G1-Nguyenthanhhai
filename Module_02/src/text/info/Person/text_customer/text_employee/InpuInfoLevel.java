package text.info.Person.text_customer.text_employee;

import casestudy_furama_resort_module_02.service.impl.person.EmployeeServiceImpl;

public class InpuInfoLevel {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        System.out.println(employeeService.infoLevel());
    }
}
