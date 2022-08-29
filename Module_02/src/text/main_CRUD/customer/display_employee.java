package text.main_CRUD.customer;

import casestudy_furama_resort_module_02.service.impl.person.CustomerServiceImpl;

public class display_employee {
    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.display();
    }
}
