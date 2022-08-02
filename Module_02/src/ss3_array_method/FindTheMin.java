package ss3_array_method;

public class FindTheMin {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{30, 2, 3, 4, 5, 6, 7, 8, 9}, {10, 11, 12, 1, 14, 15, 16, 17, 18, 19}};
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println(min);

    }
}
