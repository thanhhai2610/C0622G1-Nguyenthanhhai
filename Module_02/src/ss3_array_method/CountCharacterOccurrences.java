package ss3_array_method;

import java.util.Scanner;

public class CountCharacterOccurrences {
    public static void main(String[] args) {
        Scanner scanner= new  Scanner(System.in);
        String str = "Nguyen Thanh Hai";
        System.out.println("Nhập kí tự cần kiểm tra");
//        char input=scanner.nextLine().charAt(0);
        String input=scanner.nextLine();
        int count=0;
        for (int i = 0; i <str.length() ; i++) {
            if (input.charAt(0)==str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
