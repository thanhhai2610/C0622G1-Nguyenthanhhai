package ss6_ke_thua.Cirle_Cylinder.Controller;

import ss6_ke_thua.Cirle_Cylinder.Model.Circle;
import ss6_ke_thua.Cirle_Cylinder.Model.Cylinder;

public class MainController {
    public static void main(String[] args) {
        Circle c1= new Circle("Pink",3);
        System.out.println(c1.toString());

         Circle cl1= new Cylinder("Red",3,10);
        System.out.println(cl1.toString());

    }
}
