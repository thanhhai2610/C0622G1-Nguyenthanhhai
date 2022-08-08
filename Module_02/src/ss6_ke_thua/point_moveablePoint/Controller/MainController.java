package ss6_ke_thua.point_moveablePoint.Controller;

import ss6_ke_thua.point_moveablePoint.Model.MoveablePoint;
import ss6_ke_thua.point_moveablePoint.Model.Point;

public class MainController {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        MoveablePoint moveablePoint = new MoveablePoint(3, 4, 5, 6);

        System.out.println(point.toString());
        System.out.println(moveablePoint.toString());
        System.out.println(moveablePoint.move());
    }
}
