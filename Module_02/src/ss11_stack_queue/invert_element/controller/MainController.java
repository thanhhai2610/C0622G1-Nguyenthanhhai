package ss11_stack_queue.invert_element.controller;

import java.util.Scanner;
import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Stack<Integer> arrList = new Stack<>();
//        System.out.println("Nhập số lượng phần tử");
//        int input = Integer.parseInt(sc.nextLine());
//        int count = 0;
//        while (count < input) {
//            arrList.push(Integer.parseInt(sc.nextLine()));
//            count++;
//        }
//        for (int i = 0; i < arrList.size()+1; i++) {
//            System.out.println(arrList.pop());
//            for (int j = 0; j < arrList.size()-1 ; j++) {
//                System.out.println(arrList.push();
//            }
//        }
//        for (Integer item : arrList) {
//            System.out.println(item);
//
//        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuoi phần tử");
        String input = sc.nextLine();
        String[] input2 = input.split("");

        Stack<String> arrList = new Stack<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            arrList.push(input2[i]);
        }
        System.out.println(arrList);
        for (String item : arrList) {
            System.out.print(item);
        }
    }
}
