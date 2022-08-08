package ss6_ke_thua.Cirle_Cylinder.Model;

public class Circle {
    private String color;
    private double radius;


    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
//        return "Circle{" +
//                "color='" + color + '\'' +
//                ", radius=" + radius +
//                '}';
        return String.format("coloer: %-5s,Bán Kính: %.1f,Diện tích: %.2f", color, radius,getArea());
    }
}
