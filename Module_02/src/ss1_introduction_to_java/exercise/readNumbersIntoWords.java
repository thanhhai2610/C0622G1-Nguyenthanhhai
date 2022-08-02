package ss1_introduction_to_java.exercise;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Nhập số cần đọc thành chữ ");
        int number = scanner.nextInt();
        if (number < 10) {
            switch (number) {
                case 0:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Zero");
                    break;
                case 1:
                    System.out.println("Số " + number + " vào đuọc đọc  là : One");
                    break;
                case 2:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Two");
                    break;
                case 3:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Three");
                    break;
                case 4:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Four");
                    break;
                case 5:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Fire");
                    break;
                case 6:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Six");
                    break;
                case 7:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Seven");
                    break;
                case 8:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Eight");
                    break;
                case 9:
                    System.out.println("Số " + number + " vào đuọc đọc  là : Nine");
                    break;
            }

        } else if (number < 20) {
            String str = String.valueOf(number);
            String[] array2 = str.split("");
            switch (array2[1]) {
                case "0":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Ten");
                    break;
                case "1":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Eleven");
                    break;
                case "2":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Twelve");
                    break;
                case "3":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Thirteen");
                    break;
                case "4":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Fourteen");
                    break;
                case "5":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Fifteen");
                    break;
                case "6":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Sixteen");
                    break;
                case "7":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Seventeen");
                    break;
                case "8":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Eighteen");
                    break;
                case "9":
                    System.out.println("Số " + number + " vào đuọc đọc  là : Nineteen");
                    break;

            }
        } else if (number < 100) {
            String str2 = String.valueOf(number);
            String[] array2 = str2.split(""); //chuyen str sang mang string
            ArrayList<String> stringRead = new ArrayList<>(); //tao mang string empty
            String[] arrayNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] arrayReadFirst = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
            String[] arrayReadSecond = {"One", "two", "three", "four", "fif", "six", "seven", "eight", "nine"};
            for (int i = 1; i < arrayNumber.length; i++) {
                if (array2[0].equals(arrayNumber[i])) {
                    stringRead.add(arrayReadFirst[i - 1]);
                }
            }
            for (int i = 0; i < arrayNumber.length; i++) {
                if (array2[1].equals(arrayNumber[i])) {
                    stringRead.add(arrayReadSecond[i]);
                }
            }
            String str = String.join("-", stringRead);
            System.out.println(str);

        } else if (number > 100) {
            String str3 = String.valueOf(number);
            String[] array3 = str3.split("");
            ArrayList<String> stringRead = new ArrayList<>();
            String[] arrayNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] arrayReadFirst2 = {"One hundred", "two hundred", "three hundred", "four hundred", "fif hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
            String[] arrayReadSecond2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
            String[] arrayReadThree2 = {"One", "two", "three", "four", "fif", "six", "seven", "eight", "nine"};
            for (int i = 0; i < arrayNumber.length; i++) {
                if (array3[0].equals(arrayNumber[i])) {
                    stringRead.add(arrayReadFirst2[i]);
                }
            }
            for (int i = 0; i < arrayNumber.length; i++) {
                if (array3[1].equals(arrayNumber[i])) {
                    stringRead.add(arrayReadSecond2[i - 1]);
                }
            }
            for (int i = 0; i < arrayNumber.length; i++) {
                if (array3[2].equals(arrayNumber[i])) {
                    stringRead.add(arrayReadThree2[i]);
                }
            }
            String str = String.join(" ", stringRead);
            System.out.println(str);
        }


    }
}

