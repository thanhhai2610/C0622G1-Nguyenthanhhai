package demo.access_modifier_demo_static;

public class AccessModifier {
    public static double radius = 1;
    private static String color = "red";

    public  double radius2 = 1;
    private final String color2 = "red";



    public  AccessModifier() {
    }

    public AccessModifier(double radius, String color) {
        AccessModifier.radius = radius;
        AccessModifier.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        AccessModifier.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        AccessModifier.color = color;
    }
}
