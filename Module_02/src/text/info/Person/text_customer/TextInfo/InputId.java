package text.info.Person.text_customer.TextInfo;

import casestudy_furama_resort_module_02.service.impl.person.InputInfoPeronServiceImpl;

public class InputId {
    public static void main(String[] args) {
        InputInfoPeronServiceImpl inputInfoPeronService=new InputInfoPeronServiceImpl();
        System.out.println(inputInfoPeronService.infoId("Customer","ID Customer"));
    }
}
