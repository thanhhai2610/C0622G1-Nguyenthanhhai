package ss7_abstract_class_interface.interface_reseizeeable1.Model;


public class Square extends Rectangle implements InterfaceResizeable{
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
    public void resizeable(double percent) {
        this.setEdge(this.getArea() * (1 + percent));
    }

    @Override
    public String toString() {
        return String.format("|Square    |edge= %.2f |       -      | color: %-6s|", edge, color);

    }
}
