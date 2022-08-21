package ss7_abstract_class_interface.interface_reseizeeable1.Controller;

import ss7_abstract_class_interface.interface_reseizeeable1.Model.Circle;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Rectangle;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Shape;
import ss7_abstract_class_interface.interface_reseizeeable1.Model.Square;

import java.util.Random;

public class MainCotroller {
    public static void main(String[] args) {
        resizeable();

    }

    public static void resizeable() {
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

        Rectangle r1 = new Rectangle("red", true, 10, 10);
        Square s1 = new Square("red", true, 10);
        Shape c1 = new Circle("red", true, 10);
        Random random = new Random();
        System.out.printf("Tăng: %.2f (phần trăm )\n",new Random().nextDouble()*100);
        r1.resizeable(random.nextDouble());
        s1.resizeable(random.nextDouble());
        c1.resizeable(random.nextDouble());

        Shape[] box = new Shape[]{r1, s1, c1};
        for (int i = 0; i < box.length; i++) {
            System.out.println(box[i]);
        }
    }

}
