package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Student;
import ss10_dsa_dnah_sach.exercise_01.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> arrStudent = new ArrayList<>();

    static {
        arrStudent.add(new Student(1, "HaiNT", "NAM", "26/10/1996", "C0622G1",9));
        arrStudent.add(new Student(1, "HaiTT", "Nu", "12/12/1997", "C0622G1",9));
    }


    @Override
    public void addStudent() {
        arrStudent.add(infoStudent());
        System.out.println("Thêm mới học sinh thành công");
    }



    @Override
    public void displayAllStudent() {
        for (Student x:arrStudent) {
            System.out.println(x.toString());
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.input();
        if(student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là "+student.getiD()+" không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice == 1) {
                arrStudent.remove(student);
                System.out.println("Xóa thành công!");
            }
        }

    }
    public Student input() {
        System.out.print("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i< arrStudent.size(); i++) {
            if(arrStudent.get(i).getiD() == id) {
                return arrStudent.get(i);
            }
        }
        return null;
    }

    public Student infoStudent() {
        System.out.print("Mời bạn nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name,gender, dateOfBirth, nameClass,point);
        return student;
    }
}
