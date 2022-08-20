package ss15_exception_debug;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IllegalTriangleException();
    }

    public static void IllegalTriangleException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các canh của một hình tam giác");
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        if (a < 0 || b < 0 || c < 0 || (a + b) < c || (a + c) < b || (c + b) < a) {
            try {
                throw new CheckEdge("Bạn nhập bị lỗi");
            } catch (CheckEdge checkEdge) {
//                checkEdge.printStackTrace();
                System.out.println(checkEdge.getMessage());
            }
        }
//        System.out.println("a,b,c là cạnh của tam giác");

    }
}
