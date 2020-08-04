package de.ts.hackerrang.birthdaycakecandles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 3}, 2),
                Arguments.of(new int[]{1, 2, 1, 3}, 1),
                Arguments.of(IntStream.range(0, 10000).toArray(), 1),
                Arguments.of(IntStream.range(0, 1000000).map(value -> 5).toArray(), 1000000)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    void birthdayCakeCandles(int[] givenCandleHeights, int expectedBlownOutCandlesCount) {

        int actualBlownOutCandlesCount = Solution.birthdayCakeCandles(givenCandleHeights);

        Assertions.assertThat(actualBlownOutCandlesCount).isEqualTo(expectedBlownOutCandlesCount);
    }
}
