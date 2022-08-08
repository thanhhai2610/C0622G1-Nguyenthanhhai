package ss4_lop_va_doi_tuong_trong_java.xay_dung_lop_fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        input();
//        Fan fan1 = new Fan(2, true, 26, "blue");
//        Fan fan2 = new Fan(3, false, 26, "blue");
//        System.out.println();
    }

    public static void input() {
        int cout=0;
       while (cout<3){
           Scanner scanner = new Scanner(System.in);
           System.out.println("nhập speed từ bàn phím ");
           int speed = Integer.parseInt(scanner.nextLine());
           System.out.println("nhập sta từ bàn phím ");
           boolean sta = Boolean.parseBoolean(scanner.nextLine());
           System.out.println("nhập radius từ bàn phím ");
           double radius = Double.parseDouble(scanner.nextLine());
           System.out.println("nhập color từ bàn phím ");
           String color = scanner.nextLine();
           cout++;
           Fan n = new Fan(speed, sta, radius, color);
           System.out.println(n.toString());
       }
    }
}
