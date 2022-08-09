package ss7_abstract_class_interface.interface_colorable.Controller;

import ss7_abstract_class_interface.interface_reseizeeable1.Model.Circle;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Rectangle;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Shape;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Square;

public class MainCotroller {
    public static void main(String[] args) {
        resizeable();

    }
    public static void resizeable(){
//        Square s1 = new Square("red", true, 10);
//        Rectangle r1 = new Rectangle("red", true, 10, 10);
//        Shape c1 = new Circle("red", true, 10);
//        System.out.println(Math.random());
//        s1.resizeable(Math.random());
//        r1.resizeable(Math.random());
//        ((Circle) c1).resizeable(Math.random());
//        String[] dome = new String[3];
//        dome[0] = s1.toString();
//        dome[1] = r1.toString();
//        dome[2] = c1.toString();
//        for (String i : dome) {
//            System.out.println(i);
//        }

        Shape r1 = new Rectangle("red", true, 10, 10);
        Shape s1 = new Square("red", true, 10);
        Shape c1 = new Circle("red", true, 10);
        r1.resizeable(Math.random());
        s1.resizeable(Math.random());
        c1.resizeable(Math.random());

        Shape[] box = new Shape[]{r1, s1, c1};
        for (int i = 0; i < box.length; i++) {
            System.out.println(box[i]);
        }
    }

}
