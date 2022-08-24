package ss17_io_binary_file_serialization.product_manager.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String manufacture;
    private double price;
    private String otherDescriptions;

    public Product(String id, String name, String manufacture, double price, String otherDescriptions) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.otherDescriptions = otherDescriptions;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-4S|%-8s|%-8.2f|%-8.2s|", id, name, manufacture, price,otherDescriptions);

    }
}
