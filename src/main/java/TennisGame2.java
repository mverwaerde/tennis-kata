
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
        if (isPlayerWinning(player1Point, player2Point)) {
            return "Win for player1";
        }
        if (isPlayerWinning(player2Point, player1Point)) {
            return "Win for player2";
        }
        if (isPlayerHasAdvantage(player1Point, player2Point)) {
            return "Advantage player1";
        }
        if (isPlayerHasAdvantage(player2Point, player1Point)) {
            return "Advantage player2";
        }
        if (isDeuceGame(player1Point, player2Point)) {
            return "Deuce";
        }
        if (isEqualityGame(player1Point, player2Point) && player1Point < 4) {
            return updateScoreBeforeAdvantageWhenEquality(player1Point);
        }

        if (isPlayerLeading(player1Point, player2Point)) {
            return getLeadingPlayerScore(player1Point);
        }
        if (isPlayerLeading(player2Point, player1Point)) {
            return writeScore("Love", getPlayerPoint(player2Point));
        }

        if (isGameBeforeAdvantage(player1Point, player2Point)) {
            score = getScoreBeforeAdvantage(player1Point, player2Point);
        }
        if (!isGameBeforeAdvantage(player1Point, player2Point)) {
            if (player2Point == 2)
                player2Result = "Thirty";
            if (player2Point == 3)
                player2Result = "Forty";

            if (player1Point == 1)
                player1Result = "Fifteen";
            if (player1Point == 2)
                player1Result = "Thirty";
            score = writeScore(player1Result, player2Result);
        }


        return score;
    }

    private String getScoreBeforeAdvantage(int player1Point, int player2Point) {

        String player1Result = getWonPlayerScoreBeforeAdvantage(player1Point);
        String player2Result = getLosePlayerScoreBeforeAdvantage(player2Point);

        return writeScore(player1Result, player2Result);
    }

    private String getLosePlayerScoreBeforeAdvantage(int playerPoint) {
        if (playerPoint == 1)
            return "Fifteen";
        if (playerPoint == 2)
            return "Thirty";
        return "";
    }

    private String getWonPlayerScoreBeforeAdvantage(int playerPoint) {
        if (playerPoint == 2)
            return "Thirty";
        if (playerPoint == 3)
            return "Forty";
        return "";
    }

    private boolean isGameBeforeAdvantage(int player1Point, int player2Point) {
        return player1Point > player2Point && player1Point < 4;
    }

    private String getLeadingPlayerScore(int leadingPlayerPoint) {
        String leadingPlayerResult = getPlayerPoint(leadingPlayerPoint);
        String otherPlayer = "Love";
        return writeScore(leadingPlayerResult, otherPlayer);
    }

    private String updateScoreBeforeAdvantageWhenEquality(int playerPoint) {
        if (playerPoint == 0)
            return "Love-All";
        if (playerPoint == 1)
            return "Fifteen-All";
        if (playerPoint == 2)
            return "Thirty-All";
        return "-All";
    }

    private boolean isDeuceGame(int player1Point, int player2Point) {
        return player1Point == player2Point && player1Point >= 3;
    }

    private boolean isPlayerHasAdvantage(int player1Point, int player2Point) {
        return player1Point > player2Point && player2Point >= 3;
    }

    private boolean isPlayerWinning(int player2Point, int player1Point) {
        return player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2;
    }

    private String writeScore(String player1Result, String player2Result) {
        return player1Result + "-" + player2Result;
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