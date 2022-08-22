package ss16_io_text_file.find_maximum_value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) throws IOException {
        String path = "Module_02\\src\\ss16_io_text_file\\data\\numbers.txt";
        List<Integer> input = readFile(path);
        System.out.println(input);
        witeFile(path,findMax(input));

    }

    public static List<Integer> readFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<Integer> input = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            input.add(Integer.parseInt(line));
        }
        bufferedReader.close();
        return input;
    }

    /**
     * tìm phần tử lớn nhất tron mảng input
     *
     * @param input
     * @return phần tử có giá trị lớn nhất trong mảng input
     */
    public static int findMax(List<Integer> input) {
        int max = input.get(0);
        for (int i = 0; i < input.size(); i++) {
            if (max < input.get(i)) {
                max = input.get(i);
            }
        }
        return max;
    }

    public static void witeFile(String filePath,int max) throws IOException {
        File file = new File(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
        bufferedWriter.write("giá trị lớn nhất là: "+max);
        bufferedWriter.close();
    }
}
