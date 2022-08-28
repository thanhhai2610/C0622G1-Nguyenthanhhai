package casestudy_furama_resort_module_02.model.person;

public class Person {
    String iD;
    String name;
    String dateOfBirth;
    String gender;
    int numberIdentity;
    int numberPhone;
    String email;

    public Person(String id, String name,
                  String dateOfBirth, String gender,
                  int numberIdentity, int numberPhone,
                  String email) {
        this.iD = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberIdentity = numberIdentity;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getId() {
        return iD;
    }

    public void setId(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumberIdentity() {
        return numberIdentity;
    }

    public void setNumberIdentity(int numberIdentity) {
        this.numberIdentity = numberIdentity;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s=%s=%s=%s=%d=%d=%s",
                iD, name, dateOfBirth, gender,
                numberIdentity, numberPhone, email);

    }
}
