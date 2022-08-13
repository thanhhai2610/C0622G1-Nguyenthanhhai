package ss10_dsa_dnah_sach.exercise_01.model;

public class Teacher extends Person {
    private String level;

    public Teacher(int iD, String name, String gender, String dataOfBirth, String level) {
        super(iD, name, gender, dataOfBirth);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-6s|", level);

    }
}
