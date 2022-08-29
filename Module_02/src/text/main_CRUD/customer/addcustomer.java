package text.main_CRUD.customer;

import casestudy_furama_resort_module_02.service.impl.person.CustomerServiceImpl;

public class addcustomer {
    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.add();
    }
}
