package ss6_ke_thua.he_cac_doi_tuong_hinh_hoc.Model;

public class Rectangle extends Shape {
    protected double width;
    protected double length;


    public Rectangle(double weigth, double length) {
        this.width = weigth;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double weigth, double length) {
        super(color, filled);
        this.width = weigth;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
