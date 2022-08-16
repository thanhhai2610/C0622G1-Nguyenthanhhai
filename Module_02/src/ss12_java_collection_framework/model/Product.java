package ss12_java_collection_framework.model;

public class Product {
    private  double price;
    private String id;
    private int yearManufacture;
    private String made;

    public Product(String id, int yearManufacture, String made, double price) {
        this.id = id;
        this.yearManufacture = yearManufacture;
        this.made = made;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-4S|%-8s|%-8.2f|", id, yearManufacture, made,price);

    }
}
