package ss19_string_regex.exercise.validate_class_name;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassName className = new ClassName();

        while (true) {
            System.out.println("Nhập tên vào đi thầy:");
            String inputClass = scanner.nextLine();
            className.className();
            if (className.validate(inputClass)) {
                System.out.println("Classname is " + inputClass + " đúng");
            } else {
                System.out.println("Classname is " + inputClass + " không đúng định dạng");

            }
        }


    }

}
