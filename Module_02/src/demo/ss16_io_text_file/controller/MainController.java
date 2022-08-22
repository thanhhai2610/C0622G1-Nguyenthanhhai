package demo.ss16_io_text_file.controller;


import demo.ss16_io_text_file.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) throws IOException {
        add();
    }

    private static void add() throws IOException {
        List<Student> students = readFile();

        // Cho người dùng nhập vào
        students.add(new Student(3, "Trường", 1.5));

        // Write file
        writeFile(students);
    }

    private static void writeFile(List<Student> students) throws IOException {
        File file = new File("src/ss16_io_text_file/data/student.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Student student : students) {
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    private static List<Student> readFile() throws IOException {
        File file = new File("src/ss16_io_text_file/data/student.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> students = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            //1,Minh Châu,2.3
//            int id = Integer.parseInt(info[0]);
//            String name = info[1];
//            double score = Double.parseDouble(info[2]);
//            students.add(new Student(id, name, score));
            Student student = new Student();
            student.setId(Integer.parseInt(info[0]));
            student.setName(info[1]);
            student.setScore(Double.parseDouble(info[2]));
            students.add(student);

            System.out.println(line);
        }

        bufferedReader.close();

        return students;
    }
}