package utils.exception.check.Person.ValidateCustomer;

public class ValidateGuestType {
    public boolean validate(String inputLevel) {
        String levelRegex = "([D][i][a][m][o][n][d]|" +
                "[P][l][a][t][i][i][u][m]|" +
                "[G][o][l][d]|" +
                "[S][i][l][v][e][r]|" +
                "[M][e][m][b][e][r])";
        return inputLevel.matches(levelRegex);
    }
}
