package ss16_io_text_file.copy_file_text.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyFileController {
    public static void main(String[] args) {
        String readPath = "Module_02\\src\\ss16_io_text_file\\copy_file_text\\data\\source_file.txt";
        String writePath = "Module_02\\src\\ss16_io_text_file\\copy_file_text\\data\\target_file.txt";

        String data = "";

        try {
            data = CopyFileText.readFile(readPath);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file nguồn!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            CopyFileText.writeFile(writePath, data);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file đích!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
