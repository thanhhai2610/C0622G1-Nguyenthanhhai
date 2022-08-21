package demo.danh_sach_demo.model;

public abstract class Iphone {
    private int iD;
    private String name;
    private double price;

    public Iphone(int iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("|%-9d|%-20s|%-9f|", iD, name, price);
    }
}
