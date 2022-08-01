package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập giá trị a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập giá trị b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập giá trị c:");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
