package ss13_search_algorithm.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = binarySearch.arrSort();

        System.out.println(Arrays.toString(arr));
        System.out.println("Nhập giá trị");
        int input = Integer.parseInt(scanner.nextLine());
        if (binarySearch.binarySearch(arr, input, 0, arr.length - 1) == -1) {
            System.out.println(" không có ");
        } else {
            System.out.println(binarySearch.binarySearch(arr, input, 0, arr.length - 1));
        }
    }
}
