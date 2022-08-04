package ss2_vong_lap_trong_java;

public class DisplayingPrimeNumbersLessThan100 {
    public static void main(String[] args) {

        int input = 2;
        int count = 0;
        int i;
        boolean check ;
        while (input < 100) {
            check = true;
            for ( i = 2; i < input; i++) {
                if (input % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                System.out.print(input + " ");
            }
            input++;
        }
    }

}
