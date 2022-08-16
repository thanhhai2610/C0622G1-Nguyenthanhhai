package ss12_java_collection_framework.controller;

import ss12_java_collection_framework.service.ProductService;

import java.util.Scanner;

public class ProductManagerController {
    private static Scanner scanner = new Scanner(System.in);
    private ProductService productService = new ProductService();
    private ChoiceSortController choiceSortController = new ChoiceSortController();

    public void menuManagementProduct() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với danh sách quản lý sản phẩm");
            System.out.println("1. Thêm mới sản phẩm.");
            System.out.println("2. Hiện thị sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Sửa sản phẩm");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Sắp xếp theo giá ");
            System.out.println("7. Exit");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.remove();
                    break;
                case 4:
                    productService.update();
                    break;
                case 5:
                    productService.search();
                    break;
                case 6:
                    choiceSortController.menuManagementChoiceSort();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
