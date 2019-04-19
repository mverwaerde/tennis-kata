import java.util.Arrays;
import java.util.function.BiPredicate;

public enum GameState {
    DEUCE(GameState::isDeuceGame, "Deuce"),
    PLAYER1_ADVANTAGE(GameState::isPlayerHasAdvantage, "Advantage player1"),
    PLAYER2_ADVANTAGE((player1Point, player2Point) -> isPlayerHasAdvantage(player2Point, player1Point), "Advantage player2"),
    PLAYER1_WINNING(GameState::isPlayer1Winning, "Win for player1"),
    PLAYER2_WINNING((player1Point, player2Point) -> isPlayer1Winning(player2Point, player1Point), "Win for player2");

    private static boolean isPlayerHasAdvantage(Integer player1Point, Integer player2Point) {
        return player1Point > player2Point && player2Point >= 3;
    }

    private static boolean isDeuceGame(Integer player1Point, Integer player2Point) {
        return player1Point == player2Point && player1Point >= 3;
    }


    private static boolean isPlayer1Winning(Integer player1Point, Integer player2Point) {
        return player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2;
    }


    GameState(BiPredicate<Integer, Integer> checkCondition, String scoreLabel) {
        this.checkCondition = checkCondition;
        this.scoreLabel = scoreLabel;
    }

    private final BiPredicate<Integer, Integer> checkCondition;
    private final String scoreLabel;


    public static String of(int player1Point, int player2Point) {
        return Arrays.stream(GameState.values()).filter(gameState -> gameState.checkCondition.test(player1Point, player2Point)).findAny().get().scoreLabel;
    }
}
