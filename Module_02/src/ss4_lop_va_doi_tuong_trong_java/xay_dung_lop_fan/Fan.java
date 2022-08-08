package ss4_lop_va_doi_tuong_trong_java.xay_dung_lop_fan;

public class Fan {
    //    final int SLOW = 1;
//    final int MEDIUM = 2;
//    final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;


    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on) {
            return String.format("Speed: %d,radious: %f, color: %s",speed,radius,color) + " fan is on";
        } else {
            return  this.color + this.radius + " fan is off";
        }
    }
}
