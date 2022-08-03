package ss3_array_method;

import java.util.Scanner;

public class SumDiagonal {
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
//         Duyệt mảng
        for ( i = 0; i < arr.length; i++) {
            for ( j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        for ( i = 0; i < arr.length; i++) {
            for ( j = arr[i].length - 1; j >= 0; j--) {
                if ((arr[i].length-1) - i == j) {
//                    System.out.println(arr[i][j]);
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Kết quả là: ");
        System.out.println(sum);
    }

}
