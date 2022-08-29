package demo.hai_demo.c0622g1_mvc.src.utils.read_write;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileMap {
    public static List<String> readFile(String src) {
        FileReader file = null;
        String line = "";
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            file = new FileReader(src);
            bufferedReader = new BufferedReader(file);
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }
}
