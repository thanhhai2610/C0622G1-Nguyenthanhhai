package ss19_string_regex.exercise.validate_class_name;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidateClassName validateClassName = new ValidateClassName();
        while (true) {
            System.out.println("Nhập tên vào đi thầy:");
            String inputClass = scanner.nextLine();
            if (validateClassName.validate(inputClass)) {
                System.out.println("Classname is " + inputClass + " đúng");
            } else {
                System.out.println("Classname is " + inputClass + " không đúng định dạng");

            }
        }


    }

}
