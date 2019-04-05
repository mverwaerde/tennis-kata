
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (isEqualityGame(player1Point, player2Point) && player1Point < 4) {
            if (player1Point == 0)
                score = "Love";
            if (player1Point == 1)
                score = "Fifteen";
            if (player1Point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (isEqualityGame(player1Point, player2Point) && player1Point >= 3)
            score = "Deuce";

        if (isPlayerLeading(player1Point, player2Point)) {
            player1Result = getPlayerPoint(player1Point);
            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (isPlayerLeading(player2Point, player1Point)) {
            player2Result = getPlayerPoint(player2Point);
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }

        if (player1Point > player2Point && player1Point < 4) {
            if (player1Point == 2)
                player1Result = "Thirty";
            if (player1Point == 3)
                player1Result = "Forty";
            if (player2Point == 1)
                player2Result = "Fifteen";
            if (player2Point == 2)
                player2Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }
        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                player2Result = "Thirty";
            if (player2Point == 3)
                player2Result = "Forty";
            if (player1Point == 1)
                player1Result = "Fifteen";
            if (player1Point == 2)
                player1Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player1";
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage player2";
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for player1";
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isPlayerLeading(int player1Point, int player2Point) {
        return player1Point > 0 && player2Point == 0;
    }


    private String getPlayerPoint(int playerPoint) {
        if (playerPoint == 1)
            return "Fifteen";
        if (playerPoint == 2)
            return "Thirty";
        if (playerPoint == 3)
            return "Forty";
        return "";
    }

    private boolean isEqualityGame(int player1Point, int player2Point) {
        return player1Point == player2Point;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Point++;
        else
            player2Point++;
    }
}