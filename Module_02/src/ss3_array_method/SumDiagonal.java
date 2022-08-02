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

        int count = 1;
        int sum = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập phần tủ số " + (count));
                arr[i][j] = Integer.parseInt(scanner.nextLine());
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i + 1 == j + 1) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Kết quả là: ");
        System.out.println(sum);

    }

}
