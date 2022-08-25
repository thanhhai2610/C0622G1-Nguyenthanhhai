package ss19_string_regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "\\w+\\w*@\\w+(\\.[A-Za-z0-9])+";

    public void emailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String inputEmail) {

        matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }

}
