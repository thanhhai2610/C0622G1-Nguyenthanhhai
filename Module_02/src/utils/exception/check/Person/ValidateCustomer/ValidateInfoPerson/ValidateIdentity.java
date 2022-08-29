package utils.exception.check.Person.ValidateCustomer.ValidateInfoPerson;

public class ValidateIdentity {
    public boolean validate(String inputIdentity) {
        String identityRegex = "[0-9]{9}";
        return inputIdentity.matches(identityRegex);
    }
}
