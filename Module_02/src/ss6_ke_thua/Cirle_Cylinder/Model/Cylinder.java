package ss6_ke_thua.Cirle_Cylinder.Model;

public class Cylinder extends Circle {
    private double h;

    public Cylinder(String color, double radius,double h) {
        super(color, radius);
        this.h=h;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getEquation() {
//        V=πr2h
        return Math.PI*getRadius()*getRadius()*h;
    }

    @Override
    public String toString() {

        return String.format("coloer: %-5s,Bán Kính: %.1f,Diện tích: %.2f", getColor(), getRadius(),getEquation());

    }
}
