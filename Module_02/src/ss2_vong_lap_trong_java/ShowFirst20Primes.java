package ss2_vong_lap_trong_java;

public class ShowFirst20Primes {
    public static void main(String[] args) {
        int count = 0;
        int input = 2;
        while (count < 20) {
            boolean check = true;
            for (int i = 2; i < input; i++) {
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
