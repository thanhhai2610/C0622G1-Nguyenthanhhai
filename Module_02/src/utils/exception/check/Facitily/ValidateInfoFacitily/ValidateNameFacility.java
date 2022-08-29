package utils.exception.check.Facitily.ValidateInfoFacitily;

public class ValidateNameFacility {
    public boolean validate(String inputName) {
        String nameRegex= "\\p{Lu}\\p{Ll}+(\\s\\p{Ll}+)*";
        return inputName.matches(nameRegex) ;
    }
}
