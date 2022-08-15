//package ss11_stack_queue.invert_element.model;
//
//import java.util.Stack;
//
//public class InvertElement {
//    String input ;
//    String[] input2 = input.split("");
//    Stack<String> sym = new Stack<>();
//    Stack<String> chek2 = new Stack<>();
//
//
//        for (int i = 0; i < input2.length; i++) {
//        if (input2[i].equals("(")) {
//            sym.push(input2[i]);
//        }
//
//        if (input2[i].equals(")")) {
//            if (sym.isEmpty()) {
//                sym.push(input2[i]);
//            } else if (!input2[i].equals(sym.pop())) {
//                return;
//            }
//        }
//}
