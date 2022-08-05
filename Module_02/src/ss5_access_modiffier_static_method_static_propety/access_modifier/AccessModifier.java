package ss5_access_modiffier_static_method_static_propety.access_modifier;

public class AccessModifier {
    private double radius = 1;
    private String color = "red";

    public AccessModifier() {
    }

    public AccessModifier(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
