package utils.exception.check;


public class ValidateClassName {
    public boolean validate(String inputClassName) {
        String classClassNameRegex = "[CAP][0-9]{4}[GHIKLM]";
        return inputClassName.matches(classClassNameRegex) ;
    }
}
