import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IndividualScoreTest {

    private static Stream<Arguments> isIndividualScoreData() {
        return Stream.of(
                Arguments.of(0, "Love"),
                Arguments.of(1, "Fifteen"),
                Arguments.of(2, "Thirty"),
                Arguments.of(3, "Forty")
        );
    }


    @ParameterizedTest
    @MethodSource("isIndividualScoreData")
    public void shouldReturnLoveScore_when0(int score, String scoreLabel) {
        String result = IndividualScore.getScoreLabel(score);

        assertThat(result).isEqualTo(scoreLabel);

    }

}