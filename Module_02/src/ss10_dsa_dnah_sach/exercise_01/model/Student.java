package ss10_dsa_dnah_sach.exercise_01.model;

public class Student extends Person{
    private String className;
    private double point;


    public Student(String iD, String name, String gender, String dataOfBirth, String className, double point) {
        super(iD, name, gender, dataOfBirth);
        this.className = className;
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format(",%-15s,%.2f", className, point);

    }
}
