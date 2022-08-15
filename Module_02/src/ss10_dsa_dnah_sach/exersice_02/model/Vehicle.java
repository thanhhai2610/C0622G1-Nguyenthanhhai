package ss10_dsa_dnah_sach.exersice_02.model;

public abstract class Vehicle {
    private String licensePlates;
    private String nameBrand;
    private int yearManufacture;
    private String Owner;

    public Vehicle(String licensePlates, String nameBrand, int yearManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.nameBrand = nameBrand;
        this.yearManufacture = yearManufacture;
        Owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-10s|%-4S|%-8s|", licensePlates, nameBrand, yearManufacture, Owner);

    }
}
