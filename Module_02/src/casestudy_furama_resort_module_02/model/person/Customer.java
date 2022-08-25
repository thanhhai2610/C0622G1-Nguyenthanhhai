package casestudy_furama_resort_module_02.model.person;

public class Customer extends  Person{
    String guestType;
    String address;

    public Customer(String employeeId, String name, String dateOfBirth,
                    String gender, int numberIdentity, int numberPhone,
                    String email, String guestType, String address) {
        super(employeeId, name, dateOfBirth, gender, numberIdentity,
                numberPhone, email);
        this.guestType = guestType;
        this.address = address;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-12s||%-30s", guestType, address);

    }
}
