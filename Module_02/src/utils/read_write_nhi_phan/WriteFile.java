package utils.read_write_nhi_phan;

import java.io.*;
import java.util.List;

public class WriteFile {
    public static void writeFile(String path, List<String> lines) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Target file not Found! The system will create a new file");
                file.createNewFile();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(lines);
                fileOutputStream.close();
                objectOutputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
