package utils.exception.check.Person.ValidateCustomer.ValidateInfoPerson;

public class ValidateMail {
    public boolean validate(String inputEmail) {
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+" +
                "(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return inputEmail.matches(emailRegex) ;
    }
}
