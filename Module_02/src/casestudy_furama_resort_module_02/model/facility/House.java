package casestudy_furama_resort_module_02.model.facility;

public class House extends Facility {
    String roomStandard;
    int numberFloors;

    public House(String idService, String nameService,
                 double usableArea, double cost, int maximumPeople,
                 String rentType, String roomStandard, int numberFloors) {
        super(idService, nameService, usableArea, cost, maximumPeople, rentType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("=%s=%d=", roomStandard, numberFloors);

    }
}
