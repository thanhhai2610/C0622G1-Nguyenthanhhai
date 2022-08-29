package demo.hai_demo.c0622g1_mvc.src.view;

import demo.hai_demo.c0622g1_mvc.src.controller.StudentController;

public class MainView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.menuManagement();
    }
}
