package ss16_io_text_file.controller;

import java.io.*;

public class ReadFileStudy1 {
    public static void main(String[] args) throws IOException {
        /*
        Tương đối: src/ss16_io_text_file/data/input.txt => Hay dùng
        Tuyệt đối: E:\CodeGym\BaiGiang\QuangNN\module-2\C0622G1\src\ss16_io_text_file\data\input.txt
         */
        File file = new File("src/ss16_io_text_file/data/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

//        String line;
//        while (true) {
//            line = bufferedReader.readLine();
//
//            if (line == null) {
//                break;
//            }
//            System.out.println(line);
//        }

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if("".equals(line)) {
                continue;
            }
            System.out.println(line);
        }

        bufferedReader.close();
    }
}