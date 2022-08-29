package utils.read_write_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtil {
    /**
     * viêt ra file bất kì
     *
     * @param src    file bất kì đc viết ra
     * @param append true(k ghi đè lên file cũ),false(ghi đè lrrn file cũ)
     * @param list   Một mảng String bất kì để viết ra file.
     */
    public static void writeFile(String src, boolean append, List<String> list) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(src, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : list) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
