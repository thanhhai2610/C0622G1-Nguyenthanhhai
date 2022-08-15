package ss11_stack_queue.check_bracket.controller;

import java.util.Stack;

public class MainController {

    public static void main(String[] args) {
        String input = "s * (s – a) * (s – b) * (s – c)())(() ";
        String[] input2 = input.split("");
        System.out.print(check(input2));
    }

    public static boolean check(String[] input) {
        Stack<String> sym = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                sym.push(input[i]);
            } else if (input[i].equals(")")) {
                if (sym.isEmpty()) {
                    return false;
                }
                sym.pop();
            }
        }
        return sym.isEmpty();
    }
}
