package ss2_vong_lap_trong_java;

public class DisplayingPrimeNumbersLessThan100 {
    public static void main(String[] args) {

        int input = 2;
        while (input < 100) {
            int count = 0;
            boolean check = true;
            for (int i = 2; i < input; i++) {
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
