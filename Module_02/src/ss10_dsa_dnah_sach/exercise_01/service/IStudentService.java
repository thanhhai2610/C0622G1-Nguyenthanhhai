package ss10_dsa_dnah_sach.exercise_01.service;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void displayAllStudent();

    void removeStudent();

    void searchID();

    void searchName();

    void sortReduceStudentName();

}
