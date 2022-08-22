package ss16_io_text_file.read_file;

import demo.ss16_io_text_file.util.ReadFileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ReadFile {
    public List<String> countries;
    public void readCountries(String path) throws IOException {
        List<String> stringList = ReadFileUtil.readFile(path);

        for (String string :
                stringList) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        String path = "Module_02\\src\\ss16_io_text_file\\read_file\\country.csv";
        try {
            readFile.readCountries(path);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file nguồn!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
