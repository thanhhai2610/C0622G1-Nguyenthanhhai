package ss13_search_algorithm.find_consecutive_series;

import java.util.Scanner;

public class FindAscendingSeries {
    public String indAscendingSeries() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Bạn cần nhập chuỗi");
//        String inputStr = scanner.nextLine();
        String inputStr = "abcabcdgabmnsxy";
        String inputStrNew = "";
        inputStrNew += inputStr.charAt(0);
        int count=0;
        for (int i = 1; i < inputStr.length() - 1; i++) {

            for (int j = 0; j < inputStrNew.length(); j++) {
                if (inputStr.charAt(i) < inputStrNew.charAt(inputStrNew.length()-1)){
                    if (inputStrNew.length()>count){
//                        inputStrNew.r?
                    }
                }
                if (inputStr.charAt(i) > inputStrNew.charAt(inputStrNew.length()-1)) {
                    inputStrNew += inputStr.charAt(i);
                    count++;

                }
            }
        }
        return inputStrNew;
    }
}
