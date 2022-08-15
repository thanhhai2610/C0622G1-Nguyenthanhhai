package ss10_dsa_dnah_sach.exersice_02.model;

public class Truck extends Vehicle {
    private double Tonnage;

    public Truck(String licensePlates, String nameBrand, int yearManufacture, String owner, double tonnage) {
        super(licensePlates, nameBrand, yearManufacture, owner);
        Tonnage = tonnage;
    }

    public double getTonnage() {
        return Tonnage;
    }

    public void setTonnage(double tonnage) {
        Tonnage = tonnage;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("%-10s|%-3.2f|", "Truck", Tonnage);

    }
}
