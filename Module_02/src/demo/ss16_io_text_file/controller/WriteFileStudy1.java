package ss16_io_text_file.controller;

import java.io.*;

public class WriteFileStudy1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ss16_io_text_file/data/output.txt");
        FileWriter fileReader = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        bufferedWriter.write("Minh Châu");
        bufferedWriter.newLine();
        bufferedWriter.write("Hoàng Duy");

        bufferedWriter.close();
    }
}