package de.ts.hackerrang.jumpingontheclouds;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0}, 1),
                Arguments.of(new int[]{0, 0}, 1),
                Arguments.of(new int[]{0, 1, 0}, 1),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 0}, 3),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0}, 3),
                Arguments.of(new int[]{0, 0, 1, 0, 0, 1, 0}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void jumpingOnClouds(int[] givenClouds, int expectedMinimalJumpCount) {
        int actualMinimalJumpCount = Solution.jumpingOnClouds(givenClouds);
        Assertions.assertThat(actualMinimalJumpCount).isEqualTo(expectedMinimalJumpCount);
    }
}
