package ss7_abstract_class_interface.interface_colorable.Model;



public class Square implements InterfaceResizeable  {

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
