package ss11_stack_queue.check_bracket.controller;

import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        String input = "s * (s – a) * (s – b) * (s – c)())(() ";
        String[] input2 = input.split("");
        System.out.print(check(input2));
    }

    public static boolean check(String[] input2) {
        Stack<String> sym = new Stack<>();
        for (int i = 0; i < input2.length; i++) {
            if (input2[i].equals("(")) {
                sym.push(input2[i]);
            } else if (input2[i].equals(")")) {
                if (sym.isEmpty()) {
                    return false;
                }
                sym.pop();
            }
        }
        return sym.isEmpty();
    }
}
