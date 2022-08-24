package ss17_io_binary_file_serialization.product_manager.model.controller;


import ss17_io_binary_file_serialization.product_manager.model.service.ProductService;

import java.util.Scanner;

public class ProductManagerController {
    private static Scanner scanner = new Scanner(System.in);
    private ProductService productService = new ProductService();

    public void menuManagementProduct() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với danh sách quản lý sản phẩm");
            System.out.println("1. Thêm mới sản phẩm.");
            System.out.println("2. Hiện thị sản phẩm");
            System.out.println("3. Tìm kiếm ");
            System.out.println("4. Exit");
            System.out.print("Mời bạn nhập chức năng 1->4: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.search();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
