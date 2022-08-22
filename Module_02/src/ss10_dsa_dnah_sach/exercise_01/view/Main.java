package ss10_dsa_dnah_sach.exercise_01.view;

import ss10_dsa_dnah_sach.exercise_01.controller.PersonController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PersonController personController= new PersonController();
        personController.managementPerson();
    }
}
