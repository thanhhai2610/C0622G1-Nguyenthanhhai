package utils.read_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    /**
     * đọc một file bất kì với file là  tham số
     *
     * @param path file bất kì
     * @return mảng string chứa các kí tự trong file
     */
    public static List<String> readFile(String path) {
        List<String> stringList = new ArrayList<>();
        String line = "";
        File file = new File(path);
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                stringList.add(line);
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
        return stringList;

    }

}
