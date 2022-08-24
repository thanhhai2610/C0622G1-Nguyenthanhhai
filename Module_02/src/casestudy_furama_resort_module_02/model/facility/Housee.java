package casestudy_furama_resort_module_02.model.facility;

public class Housee extends Facility {
    String roomStandard;
    int numberFloors;

    public Housee(String nameService, double usableArea, double cost, String maximumPeople, String rentType, String roomStandard, int numberFloors) {
        super(nameService, usableArea, cost, maximumPeople, rentType);
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
        return super.toString() + String.format("%-9s||%-6d", roomStandard, numberFloors);

    }
}
