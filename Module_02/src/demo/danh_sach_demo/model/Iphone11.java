package demo.danh_sach_demo.model;

public class Iphone11 extends Iphone {
    public Iphone11(int iD, String name, double price) {
        super(iD, name, price);
    }

    @Override
    public String toString() {
        return String.format("|%-9s","Iphone11" )+super.toString();

    }
}
