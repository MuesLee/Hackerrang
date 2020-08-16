package de.ts.hackerrang.sockmerchant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(1, new int[]{10}, 0),
                Arguments.of(2, new int[]{10, 5}, 0),
                Arguments.of(2, new int[]{10, 10}, 1),
                Arguments.of(3, new int[]{10, 0, 10}, 1),
                Arguments.of(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}, 3),
                Arguments.of(100, IntStream.range(0, 100).map(i -> 10).toArray(), 50)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void sockMerchant(int sockCount, int[] sockColorCodes, int expectedPairCount) {

        int actualPairCount = Solution.sockMerchant(sockCount, sockColorCodes);

        Assertions.assertThat(actualPairCount).isEqualTo(expectedPairCount);
    }
}
