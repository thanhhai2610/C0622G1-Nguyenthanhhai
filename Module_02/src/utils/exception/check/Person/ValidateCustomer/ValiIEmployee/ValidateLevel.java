package utils.exception.check.Person.ValidateCustomer.ValiIEmployee;


public class ValidateLevel {
    public boolean validate(String inputLevel) {
        String levelRegex = "([T][r][u][n][g][ ][c][ấ][p]|" +
                "[Đ][ạ][i][ ][h][ọ][c]|" +
                "[C][a][o][ ][đ][ẳ][n][g]|" +
                "[s][a][u][ ][Đ][ạ][i][ ][h][ọ][c])";
        return inputLevel.matches(levelRegex);
    }
}
