package ss10_dsa_dnah_sach.exercise_01.service;

import java.io.IOException;

public interface ITeacherService {
    void addTeacher() throws IOException;

    void displayAllYTeacher();

    void removeTeacher();

    void searchID();

    void searchName();

    void sortReduceTeacherName();
}
