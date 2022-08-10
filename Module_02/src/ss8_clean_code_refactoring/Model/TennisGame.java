package ss8_clean_code_refactoring.Model;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;

    private static final int FORTY = 3;

    public static String readScore(String playerScoreOne, String playScoreTwo, int ScoreOfPlayerOne, int ScoreOfPlayerTwo) {

        boolean isEqual = ScoreOfPlayerOne == ScoreOfPlayerTwo;

        if (isEqual) {
            return readEqualScore(ScoreOfPlayerOne);
        }

        boolean isAdvantage = ScoreOfPlayerOne >= 4 || ScoreOfPlayerTwo >= 4;
        if (isAdvantage) {
            return readAdvantageScore(playerScoreOne, playScoreTwo, ScoreOfPlayerOne, ScoreOfPlayerTwo);
        }
        String score = playerScoreOne + " - " + playScoreTwo + "\n";
        score += readEachPlayerScore(ScoreOfPlayerOne) + " - " + readEachPlayerScore(ScoreOfPlayerTwo);
        return score;
    }

    public static String readEachPlayerScore(int score) {
        switch (score) {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
            default:
                return "-1";
        }
    }

    public static String readAdvantageScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        int advantageScore = player1Score - player2Score;

        switch (advantageScore) {
            case 1:
                return "Advantage for " + player1Name;
            case -1:
                return "Advantage for " + player2Name;
            case 2:
                return "Win for " + player1Name;
            case -2:
                return "Win for " + player2Name;
            default:
                return "The match was over";
        }
    }

    public static String readEqualScore(int player1Score) {
        return readEachPlayerScore(player1Score) + "- All";
    }
}
