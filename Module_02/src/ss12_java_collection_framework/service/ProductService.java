package ss12_java_collection_framework.service;

import ss12_java_collection_framework.model.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    Scanner scanner = new Scanner(System.in);
    private static List<Product> arrProduct = new LinkedList<>();

    static {
        arrProduct.add(new Product("1111", 1999, "Duy Trung", 10));
        arrProduct.add(new Product("2222", 1997, "Duy Xuyên", 30));
        arrProduct.add(new Product("6666", 1997, "Duy Xuyên", 20));
    }

    public void add() {
        Product tam = infoProduct();
        String tam1 = tam.getId();
        if (check(tam1, tam)) {
            System.out.print("ID bạn thêm mới bị trùng -> kiểm tra lại : ");
            return;
        } else {
            arrProduct.add(tam);
            System.out.println("Thêm sản phẩm thành công");
        }
    }

    public void remove() {
        Product product = this.input("Mời bạn nhập vào ID cần xóa: ");
        if (product == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có ID là " + product.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrProduct.remove(product);
                System.out.println("Xóa thành công!");
            }
        }
    }

    public void update() {
        Product temp = input("Mời bạn nhập id cần tìm: ");
        if (temp != null) {
            Product product = this.updeateInfoProduct(temp.getId());
            int index = arrProduct.indexOf(temp);
            System.out.println("Bạn có chắc muốn update đối tượng có ID là " + product.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrProduct.set(index, product);
                System.out.println("Update thành công!");
            }
        } else {
            System.out.println("Không tìm thấy đối tượng cần update");
        }
    }

    public void display() {
        for (Product x : arrProduct) {
            System.out.println(x.toString());
        }
    }

    public void search() {
        Product product = input("Nhập ID cần tìm kiếm");
        if (product == null) {
            System.out.println("Không tìm thấy đối tượng cần update");
        } else {
            System.out.println(product);
        }
    }

    public void sortPruductPrice() {
        for (int i = 0; i < arrProduct.size() - 1; i++) {
            for (int j = i + 1; j < arrProduct.size(); j++) {
                if (arrProduct.get(j).getPrice() < arrProduct.get(i).getPrice()) {
                    Product tam = arrProduct.get(i);
                    arrProduct.set(i, arrProduct.get(j));
                    arrProduct.set(j, tam);
                }
            }
        }
        for (Product x : arrProduct) {
            System.out.println(x.toString());
        }
    }


    public Product updeateInfoProduct(String id) {
        for (int i = 0; i < arrProduct.size(); i++) {
            if (arrProduct.get(i).getId().equals(id)) {
                System.out.print("Mời bạn nhập Năm sản xuất: ");
                int yearManufacture = Integer.parseInt(scanner.nextLine());

                System.out.print("Mời bạn nhập nơi sản xuất: ");
                String made = scanner.nextLine();

                System.out.print("Mời bạn nhập giá: ");
                double price = Integer.parseInt(scanner.nextLine());


                return new Product(id, yearManufacture, made, price);
            }
        }
        return null;
    }

    public Product input(String notification) {
        System.out.print(notification);
        String id = scanner.nextLine();
        for (int i = 0; i < arrProduct.size(); i++) {
            if (arrProduct.get(i).getId().equals(id)) {
                return arrProduct.get(i);
            }
        }
        return null;
    }

    public boolean check(String tam1, Product tam) {
        for (int i = 0; i < arrProduct.size(); i++) {
            if (arrProduct.get(i).getId().equals(tam1)) {
                return true;
            }
        }
        return false;
    }

    public Product infoProduct() {
        System.out.print("Mời bạn nhập ID: ");
        String id = scanner.nextLine();

        System.out.print("Mời bạn nhập Năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập nơi sản xuất: ");
        String made = scanner.nextLine();

        System.out.print("Mời bạn nhập giá: ");
        double price = Integer.parseInt(scanner.nextLine());


        return new Product(id, yearManufacture, made, price);
    }
}
