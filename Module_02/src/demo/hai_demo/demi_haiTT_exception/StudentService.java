//package service.impl;
//
//import model.Student;
//import service.IStudentService;
//import utils.exception.PointException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class StudentService implements IStudentService {
//    private static Scanner scanner = new Scanner(System.in);
//    private static List<Student> students = new ArrayList<>() ;
//
//    static {
//        students.add(new Student(1,"HaiTT","12/12/1222",9,"C06"));
//        students.add(new Student(1,"HaiTT","12/12/1222",9,"C06"));
//    }
//
//    @Override
//    public void addStudent() {
//
//        Student student = this.infoStudent();
//        students.add(student);
//        System.out.println("Thêm mới học sinh thành công");
//    }
//
//    @Override
//    public void displayAllStudent() {
//        for(Student student: students) {
//            System.out.println(student);
//        }
//    }
//
//    @Override
//    public void removeStudent() {
//      Student student = this.findStudent();
//      if(student == null) {
//          System.out.println("Không tìm thấy đối tượng cần xóa");
//      } else {
//          System.out.println("Bạn có chắc muốn xóa đối tượng có id là "+student.getId()+" không?");
//          System.out.println("1. Có");
//          System.out.println("2. Không");
//          int choice = Integer.parseInt(scanner.nextLine());
//          if(choice == 1) {
//              students.remove(student);
//              System.out.println("Xóa thành công!");
//          }
//      }
//
//    }
//
//    public Student findStudent() {
//        System.out.print("Mời bạn nhập vào id cần xóa: ");
//        int id = Integer.parseInt(scanner.nextLine());
//        for(int i = 0 ; i< students.size(); i++) {
//            if(students.get(i).getId() == id) {
//                return students.get(i);
//            }
//        }
//        return null;
//    }
//
//    public Student infoStudent() {
//        System.out.print("Mời bạn nhập id: ");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.print("Mời bạn nhập tên: ");
//        String name = scanner.nextLine();
//        System.out.print("Mời bạn nhập ngày sinh: ");
//        String dateOfBirth = scanner.nextLine();
//
//        double point;
//        while (true) {
//            try {
//                System.out.print("Mời bạn nhập điểm: ");
//                point = Double.parseDouble(scanner.nextLine());
//                if(point <0 || point >100) {
//                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
//                }
//                break;
//            }catch (NumberFormatException e) {
//                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
//            } catch (PointException p) {
//                System.err.println(p.getMessage());
//            } catch (Exception e) {
//
//            }
//
//        }
//        System.out.print("Mời bạn nhập tên lớp: ");
//        String nameClass = scanner.nextLine();
//        Student student = new Student(id, name, dateOfBirth, point,nameClass);
//        return student;
//    }
//}
