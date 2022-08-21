package demo.danh_sach_demo.model;

public class Iphone12 extends Iphone {
    public Iphone12(int iD, String name, double price) {
        super(iD, name, price);
    }

    @Override
    public String toString() {
        return String.format("|%-9s", "Iphone12") + super.toString();

    }
}
