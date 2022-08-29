package utils.exception.check.Person.ValidateCustomer.ValidateInfoPerson;

public class ValidateNumberPhone {
    public boolean validate(String inputNumberPhone) {
        String numberPhoneRegex = "^[0][0-9]{9}$";
        return inputNumberPhone.matches(numberPhoneRegex);
    }
}
