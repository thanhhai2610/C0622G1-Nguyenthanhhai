package ss19_string_regex.practice;

public class ValidateEmail {
    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        EmailExample emailExample = new EmailExample();
        emailExample.emailExample();

        String email = "ab@yahoo.com";
        boolean isvalid = emailExample.validate(email);
        System.out.println("Email is " + email + " is valid: " + isvalid);

        String email1 = "@gmail.com";
        boolean isvalid1 = emailExample.validate(email1);
        System.out.println("Email is " + email1 + " is valid: " + isvalid1);
    }
}
