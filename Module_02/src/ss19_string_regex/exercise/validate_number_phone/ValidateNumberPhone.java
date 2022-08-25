package ss19_string_regex.exercise.validate_number_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//^[A-Z][a-z ]+)+[A-Z][a-z]*$
public class ValidateNumberPhone {
    private static Pattern pattern;
    private static final String ValidateNumberPhone_REGEX = "[8][4][-][0-9]{10}";
    public void className() {
        pattern = Pattern.compile(ValidateNumberPhone_REGEX);
    }

    public boolean validate(String inputNumberPhone) {
        Matcher matcher = pattern.matcher(inputNumberPhone);
        return matcher.matches();
    }
}
