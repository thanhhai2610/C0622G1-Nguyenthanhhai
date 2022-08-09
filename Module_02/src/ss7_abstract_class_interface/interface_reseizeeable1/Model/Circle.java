package ss7_abstract_class_interface.interface_reseizeeable1.Model;


public class Circle extends Shape implements InterfaceResizeable {
    private double radius = 1.0; //khai báo biến bán kính

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public void resizeable(double percent) {
        this.setRadius(this.getRadius() * (1 + percent));
    }

    @Override
    public String toString() {
//        return "Circle{" +
//                "radius=" + radius +
//                ", color='" + color + '\'' +
//                ", filled=" + filled +
//                '}';
        return String.format("|Circle    |radius= %.2f|       -      | color: %-6s|", radius, color);

    }

}
