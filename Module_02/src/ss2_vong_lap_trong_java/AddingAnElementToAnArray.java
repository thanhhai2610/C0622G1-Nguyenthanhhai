package ss2_vong_lap_trong_java;

import java.util.Scanner;

public class AddingAnElementToAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập số cần chèn  ");
        int inputNumber = scanner.nextInt();
        System.out.println(" Nhập vị trí cần chèn  ");
        int inputIndex = scanner.nextInt();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i > inputIndex; i--) {
            arr[i] = arr[i - 1];
        }
        arr[inputIndex] = inputNumber;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}


