package ss19_string_regex.exercise.name;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidateName validateName = new ValidateName();
        while (true) {
            System.out.println("Nhập tên cua ban:");
            String inputClass = scanner.nextLine();
            if (validateName.validate(inputClass)) {
                System.out.println("Name is " + inputClass + " đúng");
            } else {
                System.out.println("Name is " + inputClass + " không đúng định dạng");

            }
        }
    }
}
