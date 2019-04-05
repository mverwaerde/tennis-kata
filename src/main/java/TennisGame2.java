
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (areScoresEqual() && isBeforeAdvantage(P1point)) {
            score = updateScoreBeforeAdvantageWhenEquality(score);
        }
        if (areScoresEqual() && isAdvantage(P1point)) {
            score = "Deuce";
        }

        if (P1point > 0 && P2point == 0) {
            score = updateScoreWithPlayer1Winning();
        }
        if (P2point > 0 && P1point == 0) {
            score = updateScoreWithPlayer2Winning();
        }

        if (P1point > P2point && isBeforeAdvantage(P1point)) {
            score = updateScoreBeforeAdvantageWhenPlayer1IsWinning();
        }
        if (P2point > P1point && isBeforeAdvantage(P2point)) {
            score = updateScoreBeforeAdvantageWhenPlayer2IsWinnning();
        }

        if (P1point > P2point && isAdvantage(P2point)) {
            score = "Advantage player1";
        }

        if (P2point > P1point && isAdvantage(P1point)) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isAdvantage(int playerPoint) {
        return playerPoint >= 3;
    }

    private boolean isBeforeAdvantage(int playerPoint) {
        return playerPoint < 4;
    }

    private boolean areScoresEqual() {
        return P1point == P2point;
    }

    private String updateScoreBeforeAdvantageWhenEquality(String score) {
        if (P1point == 0)
            score = "Love";
        if (P1point == 1)
            score = "Fifteen";
        if (P1point == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    private String updateScoreBeforeAdvantageWhenPlayer2IsWinnning() {
        String score;
        if (P2point == 2)
            P2res = "Thirty";
        if (P2point == 3)
            P2res = "Forty";
        if (P1point == 1)
            P1res = "Fifteen";
        if (P1point == 2)
            P1res = "Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreBeforeAdvantageWhenPlayer1IsWinning() {
        String score;
        if (P1point == 2)
            P1res = "Thirty";
        if (P1point == 3)
            P1res = "Forty";
        if (P2point == 1)
            P2res = "Fifteen";
        if (P2point == 2)
            P2res = "Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreWithPlayer2Winning() {
        String score;
        if (P2point == 1)
            P2res = "Fifteen";
        if (P2point == 2)
            P2res = "Thirty";
        if (P2point == 3)
            P2res = "Forty";

        P1res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String updateScoreWithPlayer1Winning() {
        String score;
        if (P1point == 1)
            P1res = "Fifteen";
        if (P1point == 2)
            P1res = "Thirty";
        if (P1point == 3)
            P1res = "Forty";

        P2res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}