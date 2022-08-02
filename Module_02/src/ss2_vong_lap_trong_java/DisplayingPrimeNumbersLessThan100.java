package ss2_vong_lap_trong_java;

import java.util.ArrayList;

public class DisplayingPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>(); //tao mang  empty
        int count = 0;
        int i = 2;
        while (i < 100) {
            if (isPrimeNumber(i)){
                result.add(i);
            }
            i++;
        }
        Integer[] arr = new Integer[result.size()];
        arr = result.toArray(arr);
        for ( i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    public static boolean isPrimeNumber(int input) {
        int i;
        for (i = 2; i < input; i++) {
            if ((input % i == 0) && (input % input == 0)) {
                return false ;
            }
        }
        return true;
    }
}
