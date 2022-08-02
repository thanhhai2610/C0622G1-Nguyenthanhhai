package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập vào giá trị USD");
        float usd = Float.parseFloat(scanner.nextLine());
        System.out.println(usd + " USD = " + usd * rate + " VND");
    }
}
