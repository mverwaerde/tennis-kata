import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStateTest {


    @Test
    public void shouldReturnPlayer1Win() {
        int player1Point  = 4;
        int player2Point = 1;

        String score = GameState.of(player1Point,player2Point);

        assertThat(score).isEqualTo("Win for player1");
    }

    @Test
    public void shouldReturnPlayer2Win() {
        int player1Point  = 1;
        int player2Point = 4;

        String score = GameState.of(player1Point,player2Point);

        assertThat(score).isEqualTo("Win for player2");
    }

    @Test
    public void shouldReturnDeuce() {
        int player1Point  = 3;
        int player2Point = 3;

        String score = GameState.of(player1Point,player2Point);

        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    public void shouldReturnAdvantageForPlayer1() {

        int player1Point  = 4;
        int player2Point = 3;

        String score = GameState.of(player1Point,player2Point);

        assertThat(score).isEqualTo("Advantage player1");
    }
    @Test
    public void shouldReturnAdvantageForPlayer2() {

        int player1Point  = 3;
        int player2Point = 4;

        String score = GameState.of(player1Point,player2Point);

        assertThat(score).isEqualTo("Advantage player2");
    }

}