package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class ShowGreetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập tên của bạn ");
        double name = Double.parseDouble(scanner.nextLine());
        System.out.println(" Xin chào " + name);

    }

}
