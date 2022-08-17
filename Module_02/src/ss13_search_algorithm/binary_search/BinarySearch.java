package ss13_search_algorithm.binary_search;

import java.util.Arrays;

public class BinarySearch {
    public int[] arrSort() {
        int[] arr = new int[]{10, 2, 3, 4, 50, 6, 7, 80, 9};
        Arrays.sort(arr);
        return arr;
    }
    public int binarySearch(int[] arr, int input, int left, int right) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (input == arr[mid]) {
                return mid;
            }
            if (input > arr[mid]) {
                return binarySearch(arr, input, mid + 1, right);
            }
            return binarySearch(arr, input, left, mid - 1);
        }
        return -1;
    }
}
