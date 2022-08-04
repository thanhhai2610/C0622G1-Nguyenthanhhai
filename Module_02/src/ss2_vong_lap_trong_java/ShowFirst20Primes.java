package ss2_vong_lap_trong_java;

public class ShowFirst20Primes {
    public static void main(String[] args) {
        int count = 0;
        int input = 2;
        boolean check;
        int i;
        while (count < 20) {
            check = true;
            for ( i = 2; i < input; i++) {
                if (input % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                System.out.print(input+" ");
            }
            input++;
        }
    }
}
