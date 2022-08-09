package demo.he_cac_doi_tuong_hinh_hoc.Model;

public class Square extends Rectangle {
    private double edge;

    public Square(double edge) {
        super(edge, edge);
    }

    public Square(String color, boolean filled, double edge) {
        super(color, filled, edge, edge);
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }


    @Override
    public String toString() {
        return "Square{" +
                "edge=" + edge +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
