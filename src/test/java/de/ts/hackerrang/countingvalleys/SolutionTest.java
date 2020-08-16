package de.ts.hackerrang.countingvalleys;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(2, "DU", 1),
                Arguments.of(4, "UUDD", 0),
                Arguments.of(8, "UDDDUDUU", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void countingValleys(int givenTotalStepCount, String givenSteps, int expectedValleyCount) {

        int actualValleyCount = Solution.countingValleys(givenTotalStepCount, givenSteps);

        Assertions.assertThat(actualValleyCount).isEqualTo(expectedValleyCount);
    }
}
