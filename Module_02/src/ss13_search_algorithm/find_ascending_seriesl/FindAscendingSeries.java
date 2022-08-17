package ss13_search_algorithm.find_ascending_seriesl;

import java.util.Scanner;

public class FindAscendingSeries {
    public String indAscendingSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn cần nhập chuỗi");
        String inputStr = scanner.nextLine();
        String inputStrNew = "";
        inputStrNew += inputStr.charAt(0);
        for (int i = 1; i < inputStr.length() - 1; i++) {
            for (int j = 0; j < inputStrNew.length(); j++) {
                if (inputStr.charAt(i) > inputStrNew.charAt(inputStrNew.length()-1)) {
                    inputStrNew += inputStr.charAt(i);
                }
            }
        }
        return inputStrNew;
    }
}
