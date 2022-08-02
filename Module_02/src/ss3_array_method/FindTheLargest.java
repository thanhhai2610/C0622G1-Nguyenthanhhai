package ss3_array_method;

public class FindTheLargest {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9}, {10, 11, 12, 20, 14, 15, 16, 17, 18, 19}};
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                if (arr[i][j]>max){
                    max=arr[i][j];
                }
            }
        } System.out.println(max);

    }
}
