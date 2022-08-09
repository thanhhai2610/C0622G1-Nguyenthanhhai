package demo.he_cac_doi_tuong_hinh_hoc.Controller;

import demo.he_cac_doi_tuong_hinh_hoc.Model.Circle;
import demo.he_cac_doi_tuong_hinh_hoc.Model.Rectangle;
import demo.he_cac_doi_tuong_hinh_hoc.Model.Shape;
import demo.he_cac_doi_tuong_hinh_hoc.Model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape c1 = new Circle();
        Shape r1 = new Rectangle(3, 4);
        Rectangle s1 = new Square(3);
        System.out.println(c1.toString());
        System.out.println(r1.toString());
        System.out.println(s1.toString());
    }
}
