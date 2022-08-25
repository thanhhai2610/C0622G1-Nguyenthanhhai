package ss19_string_regex.exercise.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static Pattern pattern;
    private static final String ClassName_REGEX = "[CAP][0-9]{4}[GHIKLM]";
    public void className() {
        pattern = Pattern.compile(ClassName_REGEX);
    }

    public boolean validate(String inputEmail) {
        Matcher matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }
}
