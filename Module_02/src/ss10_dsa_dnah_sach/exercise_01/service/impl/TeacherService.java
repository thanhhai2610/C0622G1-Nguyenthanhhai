package ss10_dsa_dnah_sach.exercise_01.service.impl;

import ss10_dsa_dnah_sach.exercise_01.model.Teacher;
import ss10_dsa_dnah_sach.exercise_01.service.ITeacherService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> arrTeacher = new ArrayList<>();

    static {
        arrTeacher.add(new Teacher("1", "Nguyễn Thanh Hải", "Nam", "26/10/1996", "Toán"));
        arrTeacher.add(new Teacher("2", "Nguyễn Thanh Sơn", "Nữ", "12/12/1997", "Lý"));
        arrTeacher.add(new Teacher("3", "Nguyễn Thanh Sơn", "Nữ", "12/12/1997", "Lý"));
        arrTeacher.add(new Teacher("4", "Lê Hữu Trường", "Nữ", "12/12/1997", "Lý"));
        arrTeacher.add(new Teacher("5", "Cát Uyên", "Nữ", "12/12/1997", "Lý"));
        arrTeacher.add(new Teacher("6", "Lê Bá Hoàng Giang ", "Nữ", "12/12/1997", "Lý"));
//        arrTeacher.add(new Teacher(3, "abTT", "Nữ", "12/12/1997", "Lý"));
    }

    /**
     * Thêm mới giáo viên
     */
    @Override
    public void addTeacher() throws IOException {
        String path = "Module_02\\src\\ss10_dsa_dnah_sach\\exercise_01\\data\\teacher.txt";
        List<Teacher> arrTeachers = readFile(path);

        arrTeachers.add(infoTeacher());

        writeFile(arrTeachers, path);
        System.out.println("Thêm mới giáo viên thành công");
    }

    /**
     * viết mảng vào file
     * @param arrTeacher mảng chứa đối tượng là giáo viên
     * @param path
     * @throws IOException
     */
    private static void writeFile(List<Teacher> arrTeacher, String path) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Teacher teacher : arrTeacher) {
            bufferedWriter.write(teacher.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * đọc file danh sách student
     * @param path
     * @return mảng mảng có các phần tử là đối tượng student
     * @throws IOException
     */
    private static List<Teacher> readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<Teacher> arrTeacher = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Teacher teacher = new Teacher(info[0],info[1],info[2],info[3],info[4]);
            arrTeacher.add(teacher);
        }
        bufferedReader.close();
        return arrTeacher;
    }


    /**
     * hiểm thị all giáo viên
     */
    @Override
    public void displayAllYTeacher() {
        for (Teacher x : arrTeacher) {
            System.out.println(x.toString());
        }

    }

    /**
     * xoá giáo viên theo ID
     */
    @Override
    public void removeTeacher() {
        Teacher teacher = this.inputID();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getiD() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrTeacher.remove(teacher);
                System.out.println("Xóa thành công!");
            }
        }
    }

    /**
     * tìm kiếm giáo viên theo ID
     */
    public void searchID() {
        Teacher teacherGetI = inputID();
        if (teacherGetI == null) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            System.out.println(teacherGetI);
        }
    }

    /**
     * tiềm kiếm giáo viên theo tên
     */
    public void searchName() {
        List<Teacher> searchTeacher = new ArrayList<>();
        System.out.print("Mời bạn nhập vào tên : ");
        String name = scanner.nextLine();
//        for (int i = 0; i < arrTeacher.size(); i++) {
//            if (arrTeacher.get(i).getName().contains(name)) {
//                searchStudent.add(arrTeacher.get(i).getName());
//            }
//        }
        for (Teacher teacher : arrTeacher) {
            if (teacher.getName().contains( name)) {
                searchTeacher.add(teacher);
            }
        }
        if (searchTeacher.isEmpty()) {
            System.out.println("Không tìm thấy đối tượng ");
        } else {
            for (Teacher teacher : searchTeacher) {
                System.out.println(teacher.toString());

            }
        }
    }
    /**
     * check name
     *
     * @return vùng nhớ dữ liệu chứa Name nhập vào
     */

    public Teacher inputName() {

        return null;
    }

    /**
     * sắp xếo giáo viên theo tên
     */
    public void sortReduceTeacherName() {
        boolean isSwap = true;
        for (int i = 0; i < arrTeacher.size() - 1; i++) {
            isSwap = false;
            for (int j = i + 1; j < arrTeacher.size(); j++) {
                if ((arrTeacher.get(j).getName()).compareTo(arrTeacher.get(i).getName()) > 0) {
                    Teacher tam = arrTeacher.get(i);
                    arrTeacher.set(i, arrTeacher.get(j));
                    arrTeacher.set(j, tam);
                    isSwap = true;
                }
            }
        }
        for (Teacher x : arrTeacher) {
            System.out.println(x.toString());
        }
    }



    /**
     * check ID nhập vào
     *
     * @return vùng hớ dữ liệu có chưa ID nhập vào
     */
    public Teacher inputID() {
        System.out.print("Mời bạn nhập vào id cần xóa: ");
        String id = (scanner.nextLine());
        for (int i = 0; i < arrTeacher.size(); i++) {
            if (arrTeacher.get(i).getiD().equals(id)) {
                return arrTeacher.get(i);
            }
        }
        return null;
    }

    /**
     * Nhập thông tin cho giáo viên
     *
     * @return vùng nhớ chưa thông tin giáo viên
     */
    public Teacher infoTeacher() {
        System.out.print("Mời bạn nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn chuyên môn: ");
        String level = scanner.nextLine();

        return new Teacher(id, name, gender, dateOfBirth, level);
    }


}
