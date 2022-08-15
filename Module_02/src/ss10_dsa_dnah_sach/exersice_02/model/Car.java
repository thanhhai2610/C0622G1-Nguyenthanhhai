package ss10_dsa_dnah_sach.exersice_02.model;

public class Car extends Vehicle {
    private int numberSeats;
    private String vehicleType;

    public Car(String licensePlates, String nameBrand, int yearManufacture, String owner, int numberSeats, String vehicleType) {
        super(licensePlates, nameBrand, yearManufacture, owner);
        this.numberSeats = numberSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s|%-3d|%-10s|","Cars", numberSeats, vehicleType);

    }
}
