package ss19_string_regex.exercise.name;

public class ValidateName {
    public boolean validate(String inputEmail) {
        String nameREGEX = "\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*";
        return inputEmail.matches(nameREGEX) && inputEmail.length()>5 && inputEmail.length()<50 ;
    }
}
