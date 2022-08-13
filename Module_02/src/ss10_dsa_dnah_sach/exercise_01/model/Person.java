package ss10_dsa_dnah_sach.exercise_01.model;

public abstract class Person {
    private int iD;
    private String name;
    private String gender;
    private String dataOfBirth;

    public Person(int iD, String name, String gender, String dataOfBirth) {
        this.iD = iD;
        this.name = name;
        this.gender = gender;
        this.dataOfBirth = dataOfBirth;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return String.format("|%-9d|%-10s|%-4S|%-8s|", iD, name, gender, dataOfBirth);

    }
}
