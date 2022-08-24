package ss10_dsa_dnah_sach.exercise_01.service;

import java.io.IOException;
import java.text.ParseException;

public interface IStudentService {
    void addStudent() throws IOException, ParseException;

    void displayAllStudent();

    void removeStudent();

    void searchID();

    void searchName();

    void sortReduceStudentName();

}
