package ss2_vong_lap_trong_java;


public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr[i]=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[arr1.length+i] = arr2[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
