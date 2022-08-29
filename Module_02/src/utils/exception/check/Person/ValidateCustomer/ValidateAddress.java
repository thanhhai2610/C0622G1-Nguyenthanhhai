package utils.exception.check.Person.ValidateCustomer;

public class ValidateAddress {
    public boolean validate(String inputAddress) {
        String addressRegex = "(\\p{Lu}\\p{Ll})+(\\s\\p{Lu}\\p{Ll}+)*";
        return inputAddress.matches(addressRegex);
    }
}
