package ss2_vong_lap_trong_java;

public class DisplayTypes {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < 6; i++) {

            for (int j = 2; j < 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();

            for (int j = 5; j > i; j--) {
                System.out.print("0");
            }

        }


    }

}
