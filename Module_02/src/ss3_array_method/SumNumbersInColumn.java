package ss3_array_method;

import java.util.Scanner;

public class SumNumbersInColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng  ");
        int inputRow = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập số cột  ");
        int inputCol = Integer.parseInt(scanner.nextLine());

        int[][] arr = new int[inputRow][inputCol];
        int sum = 0;
        int count=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập phần tủ số " + (count));
                arr[i][j] = Integer.parseInt(scanner.nextLine());
                count++;
            }
        }
        int indexCol;
        do {
            System.out.println("Nhập cột cần tính tổng ");
            indexCol = Integer.parseInt(scanner.nextLine());
            if ((indexCol < 0 || indexCol > arr.length - 1)) {
                System.out.println("Bạn cần nhập cột trong khoảngt[0;2] ");
            }
        } while (indexCol < 0 || indexCol > arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == indexCol) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Kết quả là: ");
        System.out.println(sum);

    }
}
