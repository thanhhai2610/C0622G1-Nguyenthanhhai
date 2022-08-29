package utils.exception.check.Person.ValidateCustomer.ValiIEmployee;

public class ValidateLocation {
    public boolean validate(String inputLevel) {
        String levelRegex = "([L][ễ][ ][t][â][n]|" +
                "[P][h][ụ][c][ ][v][ụ]|" +
                "[C][h][u][y][ê][n][ ][v][i][ê][n]|" +
                "[Q][u][ả][n][ ][l][ý]|" +
                "[G][i][á][m][ ][đ][ố][c]|" +
                "[G][i][á][m][ ][s][á][t])";
        return inputLevel.matches(levelRegex);
    }
}
