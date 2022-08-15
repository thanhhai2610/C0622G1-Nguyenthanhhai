package ss10_dsa_dnah_sach.exersice_02.model;

public class  Motor extends Vehicle {
    private double Wattage;

    public Motor(String licensePlates, String nameBrand, int yearManufacture, String owner, double wattage) {
        super(licensePlates, nameBrand, yearManufacture, owner);
        Wattage = wattage;
    }

    public double getWattage() {
        return Wattage;
    }

    public void setWattage(double wattage) {
        Wattage = wattage;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("%-10s|%-3.2f|", "Motor", Wattage);

    }
}
