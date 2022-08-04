package demo;

import java.util.Scanner;

public class FindTheMin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng  ");
        int inputRow = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số cột  ");
        int inputCol = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[inputRow][inputCol];
        int sum = arr[0][0];
        int i;
        int j;

//      nhập mảng
        int count = 1;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập phần tủ số " + (count));
                arr[i][j] = Integer.parseInt(scanner.nextLine());
                count++;
            }
        }
        ten( arr);

    }

    public static void ten (int [][] arr) {
        int i;
        int j;
        int min = arr[0][0];
        for ( i = 0; i < arr.length; i++) {
            for ( j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println("Số nhỏ nhất trong mảng là: "+min);

    }
}
