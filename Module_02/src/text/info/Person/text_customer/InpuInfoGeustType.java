package text.info.Person.text_customer;

import casestudy_furama_resort_module_02.service.impl.person.CustomerServiceImpl;

public class InpuInfoGeustType {
    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println(customerService.infoGuestType());
    }
}
