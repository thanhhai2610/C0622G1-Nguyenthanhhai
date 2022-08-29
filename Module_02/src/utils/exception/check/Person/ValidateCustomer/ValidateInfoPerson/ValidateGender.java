package utils.exception.check.Person.ValidateCustomer.ValidateInfoPerson;

public class ValidateGender {
    public boolean validate(String inputGender) {
        String genderRegex = "([N][a][m])|([N][Ữ])|([K][h][á][c])";
        return inputGender.matches(genderRegex) ;
    }
}
