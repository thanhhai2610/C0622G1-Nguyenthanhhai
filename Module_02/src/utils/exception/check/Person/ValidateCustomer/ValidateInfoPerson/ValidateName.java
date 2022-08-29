package utils.exception.check.Person.ValidateCustomer.ValidateInfoPerson;

public class ValidateName {
    public boolean validate(String inputName) {
        String nameRegex= "\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*";
        return inputName.matches(nameRegex) && inputName.length()>5 && inputName.length()<50 ;
    }
}
