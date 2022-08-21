package demo.arraylist.Controller;

import demo.arraylist.Model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        Student s1 = new Student(111170065, "Thanh Hải", 1996, 2.76);
        Student s2 = new Student(111170066, "Hữu Trường", 1997, 3.01);
        Student s3 = new Student(111170050, "Cát Uyên", 1997, 2.00);
        List<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).getDiemTrungBinh() < arr.get(i).getDiemTrungBinh()) {
                    Student tam = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tam);
                }
            }
        }
        for (Student x : arr) {
            System.out.println(x.toString());
        }
    }
}
