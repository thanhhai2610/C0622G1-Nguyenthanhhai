package ss2_vong_lap_trong_java;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {

//        System.out.println(" Nhập số phần tử ");
//        int input= scanner.nextInt();
//        int count=0;
//        int[] arr;
//        do {
//            arr = new int[5];
//
//            count++;
//        }while (count<input);
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập số cần xoá  ");
        int input = scanner.nextInt();
        int index = 0;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            if (input == arr[i]) {
                index = i;
            }
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
