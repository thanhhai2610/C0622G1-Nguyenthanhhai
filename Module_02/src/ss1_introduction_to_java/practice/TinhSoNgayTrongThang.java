package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        int month = scanner.nextInt();

        switch (month) {
            case 2:
                System.out.println("Tháng 2 có 28 or 29 ngày ");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày ");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày ");
                break;


        }
    }

}
