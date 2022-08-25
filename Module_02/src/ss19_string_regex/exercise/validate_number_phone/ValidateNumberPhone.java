package ss19_string_regex.exercise.validate_number_phone;

public class ValidateNumberPhone {
    public boolean validate(String inputNumberPhone) {
        String ValidateNumberPhoneRegex = "[8][4][-][0-9]{10}";
        return inputNumberPhone.matches(ValidateNumberPhoneRegex);
    }
}
