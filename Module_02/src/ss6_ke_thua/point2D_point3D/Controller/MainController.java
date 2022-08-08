package ss6_ke_thua.point2D_point3D.Controller;


import ss6_ke_thua.point2D_point3D.Model.Point2D;
import ss6_ke_thua.point2D_point3D.Model.Point3D;


public class MainController {
    public static void main(String[] args) {
        Point2D P21 = new Point2D(3, 4);
        System.out.println(P21);
        Point2D P31 = new Point3D(3,4,5);
        System.out.println(P31);
    }
}
