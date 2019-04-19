
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        if (GameState.isGameSpecialValue(player1Point, player2Point)) {
            return GameState.of(player1Point, player2Point);
        }
        if (player1Point != player2Point) {
            return writeScore();
        }
        return writeEqualityScore();

    }

    private String writeEqualityScore() {
        return IndividualScore.getScoreLabel(player1Point) +"-All";
    }

    private String writeScore() {
        return IndividualScore.getScoreLabel(player1Point) + "-" + IndividualScore.getScoreLabel(player2Point);
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Point++;
        else
            player2Point++;
    }
}