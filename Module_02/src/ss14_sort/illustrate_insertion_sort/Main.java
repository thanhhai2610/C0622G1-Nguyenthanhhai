package ss14_sort.illustrate_insertion_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{7, 8, 9, 1, 2, 3, 6, 5, 4};
        InsertionSorrt(list);
    }

    public static void InsertionSorrt(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
                System.out.print("Swap " + key + " with " + list[j + 1]+"\n");

            }
            list[j + 1] = key;
            System.out.print(list[j+1] + "\n");

        }
        System.out.println(Arrays.toString(list));

    }

}
