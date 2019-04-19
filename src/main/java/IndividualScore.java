import java.util.Arrays;

public enum IndividualScore {

    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty"),

    ;

    private final int score;
    private final String scoreLabel;

    IndividualScore(int score, String scoreLabel) {
        this.score = score;
        this.scoreLabel = scoreLabel;
    }

    public static String getScoreLabel(int playerPoint) {
        return Arrays.stream(IndividualScore.values()).filter(individualScore -> individualScore.score == playerPoint).findAny().get().scoreLabel;
    }
}
