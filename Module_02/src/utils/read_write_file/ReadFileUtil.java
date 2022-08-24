package utils.read_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    /**
     * đọc một file bất kì với file là  tham số
     *
     * @param src file bất kì
     * @return mảng string chứa các kí tự trong file
     */
    public static List<String> readFile(String src) {
        List<String> strings = new ArrayList<>();
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(src);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
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
