package de.ts.hackerrang.arrayleftrotation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, new int[]{5, 1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, new int[]{2, 3, 4, 5, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void testRotateLeft(int[] givenArray, int shiftLeftCount, int[] expectedRotatedArray) {
        int[] actualRotatedArray = Solution.rotateLeft(givenArray, shiftLeftCount);

        Assertions.assertThat(actualRotatedArray).isEqualTo(expectedRotatedArray);
    }
}
