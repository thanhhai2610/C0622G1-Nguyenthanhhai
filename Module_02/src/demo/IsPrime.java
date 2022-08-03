package demo;

public class IsPrime {
    public static void main(String[] args) {
        int cout = 0;
        int i = 2;
        while (cout < 20) {
           if (isPrime(i)){
               System.out.print(i + " ");
               cout++;
           }
            i++;
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
