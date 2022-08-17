package ss12_java_collection_framework.service;

import ss12_java_collection_framework.model.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    Scanner scanner = new Scanner(System.in);
    private static List<Product> arrProduct = new LinkedList<>();

    static {
        arrProduct.add(new Product("1111", 1999, "Duy Trung", 10));
        arrProduct.add(new Product("2222", 1997, "Duy Xuyên", 30));
        arrProduct.add(new Product("6666", 1997, "Duy Xuyên", 20));
    }

    /**
     * thêm mới một sản phẩm
     */
    public void add() {
        Product product = infoProduct();
        String productID = product.getId();
        if (check(productID, product)) {
            System.out.print("ID bạn thêm mới bị trùng -> kiểm tra lại : ");
            return;
        } else {
            arrProduct.add(product);
            System.out.println("Thêm sản phẩm thành công");
        }
    }

    /**
     * xoá một sản phẩm theo ID
     */
    public void remove() {
        Product productGetI = this.inputID("Mời bạn nhập vào ID cần xóa: ");
        if (productGetI == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có ID là " + productGetI.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrProduct.remove(productGetI);
                System.out.println("Xóa thành công!");
            }
        }
    }

    /**
     * update một sản phẩm theo ID
     */
    public void update() {
        Product productGetI = inputID("Mời bạn nhập id cần tìm: ");
        if (productGetI != null) {
            Product productUpdate = this.updateInfoProduct(productGetI.getId());
            int index = arrProduct.indexOf(productGetI);
            System.out.println("Bạn có chắc muốn update đối tượng có ID là " + productUpdate.getId() + " không?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                arrProduct.set(index, productUpdate);
                System.out.println("Update thành công!");
            }
        } else {
            System.out.println("Không tìm thấy đối tượng cần update");
        }
    }

    /**
     * hiển thị all product
     */
    public void display() {
        for (Product x : arrProduct) {
            System.out.println(x.toString());
        }
    }

    /**
     * tìm kiếm sản phẩm theo ID
     */
    public void search() {
        Product productGetI = inputID("Nhập ID cần tìm kiếm");
        if (productGetI == null) {
            System.out.println("Không tìm thấy đối tượng cần update");
        } else {
            System.out.println(productGetI);
        }
    }

    /**
     * sắp xếp product theo chiều tăng dần
     */
    public void sortRaiseProductPrice() {
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

    /**
     * sắp xếp product theo chiều giảm dần
     */
    public void sortReduceProductPrice() {
        for (int i = 0; i < arrProduct.size() - 1; i++) {
            for (int j = i + 1; j < arrProduct.size(); j++) {
                if (arrProduct.get(j).getPrice() > arrProduct.get(i).getPrice()) {
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

    /**
     * cập nhật thông tin sản phẩm mới
     *
     * @param id
     * @return sản phâm có thông tin mới or (null)
     */
    public Product updateInfoProduct(String id) {
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

    /**
     * nhập ID và kiểm tra ID nhập vào có đúng không?
     *
     * @param notification
     * @return sản phẩm(vùng nhớ) ở vị trí thứ i or (null)
     */
    public Product inputID(String notification) {
        System.out.print(notification);
        String id = scanner.nextLine();
        for (int i = 0; i < arrProduct.size(); i++) {
            if (arrProduct.get(i).getId().equals(id)) {
                return arrProduct.get(i);
            }
        }
        return null;
    }

    /**
     * kiểm tra id nhập vào dã có chưa
     *
     * @param tam1
     * @param tam
     * @return có or không
     */
    public boolean check(String tam1, Product tam) {
        for (int i = 0; i < arrProduct.size(); i++) {
            if (arrProduct.get(i).getId().equals(tam1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Nhập thông tin cho một sản phẩm mới
     *
     * @return một sản phẩm có (id,năm sx,made,giá)
     */
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
