package casestudy_furama_resort_module_02.model.facility;

public class Room extends Facility {
    String freeServiceIncluded;

    public Room(String idService, String nameService,
                double usableArea, double cost, String maximumPeople,
                String rentType, String freeServiceIncluded) {
        super(idService, nameService, usableArea, cost, maximumPeople, rentType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("||%-9s", freeServiceIncluded);

    }
}
