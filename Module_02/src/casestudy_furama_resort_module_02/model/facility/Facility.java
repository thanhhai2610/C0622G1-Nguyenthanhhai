package casestudy_furama_resort_module_02.model.facility;

public abstract class Facility {
    String idService;
    String nameService;
    double usableArea;
    double cost;
    String maximumPeople;
    String rentType;

    public Facility(String idService, String nameService,
                    double usableArea, double cost, String maximumPeople,
                    String rentType) {
        this.idService = idService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.cost = cost;
        this.maximumPeople = maximumPeople;
        this.rentType = rentType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(String maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return String.format("%-9s||%-9s||%-6.2f||%-6.2f||%-5s||%-12s||",idService, nameService, usableArea, cost, maximumPeople,rentType);

    }
}
