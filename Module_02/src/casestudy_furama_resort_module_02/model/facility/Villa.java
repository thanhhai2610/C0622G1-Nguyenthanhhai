package casestudy_furama_resort_module_02.model.facility;

public class Villa extends Facility {
    String roomStandard;
    double poolArea;
    int numberFloors;

    public Villa(String nameService, double usableArea, double cost, String maximumPeople, String rentType, String roomStandard, double poolArea, int numberFloors) {
        super(nameService, usableArea, cost, maximumPeople, rentType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-9s||%-6.2f||%-6d", roomStandard, poolArea, numberFloors);

    }
}
