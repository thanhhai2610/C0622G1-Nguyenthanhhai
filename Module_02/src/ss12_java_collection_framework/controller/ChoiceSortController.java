package ss12_java_collection_framework.controller;

import ss12_java_collection_framework.service.ProductService;

import java.util.Scanner;

public class ChoiceSortController {
    private static Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();

    public void menuManagementChoiceSort() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1. Sắp xếp theo giá tăng dân.");
            System.out.println("2. Sắp xếp theo giá giảm dân.");
            System.out.println("3. Trở vể menu chính.");
            System.out.print("Mời bạn nhập chức năng 1->2: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.sortRaiseProductPrice();
                    break;
                case 2:
                    productService.sortReduceProductPrice();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
