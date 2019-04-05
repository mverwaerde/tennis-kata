
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (hasPlayer1Won(player1Point, player2Point)) {
            return "Win for player1";
        }
        if (hasPlayer2Won(player1Point, player2Point)) {
            return "Win for player2";
        }
        if (hasPlayer1Advantage()) {
            return "Advantage player1";
        }
        if (hasPlayer2Advantage()) {
            return "Advantage player2";
        }
        if (isDeuce()) {
            return "Deuce";
        }
        if (isEquality()) {
            return updateScoreBeforeAdvantageWhenEquality();
        }
        if (onlyPlayer1HasPoints()) {
            return updateScoreWithPlayer1Winning();
        }
        if (onlyPlayer2HasPoint()) {
            return updateScoreWithPlayer2Winning();
        }
        if (isPlayer1Leading()) {
            return updateScoreWhenPlayer1Leads();
        }
        if (isPlayer2Leading()) {
            return updateScoreWhenPlayer2Leads();
        }
        return "";
    }

    private boolean isEquality() {
        return areScoresEqual() && player1Point < 4;
    }

    private boolean isDeuce() {
        return areScoresEqual() && player1Point >= 3;
    }

    private boolean onlyPlayer2HasPoint() {
        return player2Point > 0 && player1Point == 0;
    }

    private boolean onlyPlayer1HasPoints() {
        return player1Point > 0 && player2Point == 0;
    }

    private boolean isPlayer1Leading() {
        return player2Point < player1Point && player1Point < 4;
    }

    private boolean isPlayer2Leading() {
        return player2Point > player1Point && player2Point < 4;
    }

    private boolean hasPlayer1Advantage() {
        return player1Point > player2Point && player2Point >= 3;
    }

    private boolean hasPlayer2Advantage() {
        return player2Point > player1Point && player1Point >= 3;
    }

    private boolean hasPlayer2Won(int player1Point, int player2Point) {
        return player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2;
    }

    private boolean hasPlayer1Won(int player1Point, int player2Point) {
        return player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2;
    }

    private boolean areScoresEqual() {
        return player1Point == player2Point;
    }

    private String updateScoreBeforeAdvantageWhenEquality() {
        if (player1Point == 0)
            return "Love-All";
        if (player1Point == 1)
            return "Fifteen-All";
        if (player1Point == 2)
            return "Thirty-All";
        return "-All";
    }

    private String updateScoreWhenPlayer2Leads() {
        String score;
        if (player2Point == 2)
            P2res = "Thirty";
        if (player2Point == 3)
            P2res = "Forty";
        if (player1Point == 1)
            P1res = "Fifteen";
        if (player1Point == 2)
            P1res = "Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreWhenPlayer1Leads() {
        String score;
        if (player1Point == 2)
            P1res = "Thirty";
        if (player1Point == 3)
            P1res = "Forty";
        if (player2Point == 1)
            P2res = "Fifteen";
        if (player2Point == 2)
            P2res = "Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreWithPlayer2Winning() {
        String score;
        if (player2Point == 1)
            P2res = "Fifteen";
        if (player2Point == 2)
            P2res = "Thirty";
        if (player2Point == 3)
            P2res = "Forty";

        P1res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreWithPlayer1Winning() {
        String score;
        if (player1Point == 1)
            P1res = "Fifteen";
        if (player1Point == 2)
            P1res = "Thirty";
        if (player1Point == 3)
            P1res = "Forty";

        P2res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Point++;
        else
            player2Point++;
    }
}