package ss4_lop_va_doi_tuong_trong_java.stop_watch;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.getStartTime());
        demo();
        stopWatch.stop();
        System.out.println(stopWatch.getEndTime());
        System.out.println(stopWatch.getElapsedTime());
     }

    static  void demo() {
        int demo = 0;
        for (int i = 0; i < 1000000000;i++){
         demo = i;
        }
    }
}
