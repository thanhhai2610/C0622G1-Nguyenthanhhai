package utils.read_write_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadSourceFile {

    public static List<String> readBinaryFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            lines = (List<String>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lines;

    }
}
