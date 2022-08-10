package ss8_clean_code_refactoring.Controller;

import java.util.Scanner;

public class TenNisGameController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Score of player1");
        int player1Score = Integer.parseInt(scanner.nextLine());
        System.out.println("Score of play2");
        int player2Score = Integer.parseInt(scanner.nextLine());
        System.out.println(readScore("Lão hạc", "Cậu Vàng",
                player1Score, player2Score));
    }


}
