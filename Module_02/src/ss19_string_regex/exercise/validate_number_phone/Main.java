package ss19_string_regex.exercise.validate_number_phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidateNumberPhone validateNumberPhone = new ValidateNumberPhone();

        while (true) {
            System.out.println("Nhập số điện thoại vào đi thầy:");
            String inputClass = scanner.nextLine();
            if (validateNumberPhone.validate(inputClass)) {
                System.out.println("Số is " + inputClass + " đúng");
            } else {
                System.out.println("Số is " + inputClass + " không đúng định dạng");

            }
        }
    }
}
