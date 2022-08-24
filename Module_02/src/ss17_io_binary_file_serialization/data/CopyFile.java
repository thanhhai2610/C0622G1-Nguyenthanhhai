package ss17_io_binary_file_serialization.data;

import utils.read_write_nhi_phan.ReadSourceFile;
import utils.read_write_nhi_phan.WriteFile;

import java.util.List;

public class CopyFile {

    public static final String SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_DATA_SOURCE_DAT = "Module_02\\src\\ss17_io_binary_file_serialization\\data\\data\\source.dat";
    public static final String SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_DATA_TARGET_DAT = "Module_02\\src\\ss17_io_binary_file_serialization\\data\\data\\target.dat";
    public static void main(String[] args) {
        String sourcePath = SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_DATA_SOURCE_DAT;
        String targetPath = SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_DATA_TARGET_DAT;
        List list = ReadSourceFile.readBinaryFile(sourcePath);
        WriteFile.writeFile(targetPath, list);
    }
}