package ss17_io_binary_file_serialization.product_manager.model.view;

import ss17_io_binary_file_serialization.product_manager.model.controller.ProductManagerController;
import ss17_io_binary_file_serialization.product_manager.model.service.ProductService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static final String SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_PRODUCT_DAT = "Module_02\\src\\ss17_io_binary_file_serialization\\data\\product.dat";
    public static void main(String[] args) {
        ProductManagerController productManagerController = new ProductManagerController();
        productManagerController.menuManagementProduct();
        ProductService productService=new ProductService();
        writeToFile(SRC_SS_17_IO_BINARY_FILE_SERIALIZATION_DATA_PRODUCT_DAT,productService.toString());
    }
    public static void writeToFile(String path,String products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
