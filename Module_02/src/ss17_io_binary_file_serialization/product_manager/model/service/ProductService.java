package ss17_io_binary_file_serialization.product_manager.model.service;


import ss17_io_binary_file_serialization.product_manager.model.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    Scanner scanner = new Scanner(System.in);
    private static List<Product> arrProduct = new LinkedList<>();

    static {
        arrProduct.add(new Product("1111", "máy tính", "dell", 10,"cùi"));
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

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Mời bạn nhập hãng: ");
        String manufacture = scanner.nextLine();

        System.out.print("Mời bạn nhập giá: ");
        double price = Integer.parseInt(scanner.nextLine());

        System.out.print("Mời bạn nhập ncác khác: ");
        String otherDescriptions = scanner.nextLine();

        return new Product(id, name, manufacture, price,otherDescriptions);
    }
}
