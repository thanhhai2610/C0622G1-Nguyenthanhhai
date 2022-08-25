package ss19_string_regex.exercise.validate_class_name;


public class ValidateClassName {
    public boolean validate(String inputClassName) {
        String classNameRegex = "[CAP][0-9]{4}[GHIKLM]";
        return inputClassName.matches(classNameRegex)  ;
    }
}
