package de.ts.hackerrang.arrayhourglass;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0}
                        }, 7
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0},
                                {0, 0, 0, 2, 2, 2},
                                {0, 0, 0, 2, 2, 2},
                                {0, 0, 0, 2, 2, 2}
                        }, 14
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 3, 3, 3},
                                {1, 1, 1, 3, 3, 3},
                                {1, 1, 1, 3, 3, 3},
                                {0, 0, 0, 2, 2, 2},
                                {0, 0, 0, 2, 2, 2},
                                {0, 0, 0, 2, 2, 2}
                        }, 21
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 3, 3, 3},
                                {1, 1, 1, 3, 3, 3},
                                {1, 1, 1, 3, 3, 3},
                                {4, 4, 4, 2, 2, 2},
                                {4, 4, 4, 2, 2, 2},
                                {4, 4, 4, 2, 2, 2}
                        }, 28
                ),
                Arguments.of(
                        new int[][]{
                                {-9, -9, -9, 1, 1, 1},
                                {0, -9, 0, 4, 3, 2},
                                {-9, -9, -9, 1, 2, 3},
                                {0, 0, 8, 6, 6, 0},
                                {0, 0, 0, -2, 0, 0},
                                {0, 0, 1, 2, 4, 0}
                        }, 28
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0},
                                {0, 0, 2, 4, 4, 0},
                                {0, 0, 0, 2, 0, 0},
                                {0, 0, 1, 2, 4, 0}
                        }, 19
                )

        );
    }

    private static Stream<Arguments> hourglasses() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {0, 4, 0},
                                {5, 6, 7},
                        }, 28
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 1},
                                {1, 1, 1},
                        }, 7
                ),
                Arguments.of(
                        new int[][]{
                                {-1, 1, -1},
                                {1, 1, 1},
                                {-1, 1, -1},
                        }, -1
                )

        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void testMaxHourglassSum(int[][] givenArray, int expectedMaxHourglassSum) {

        int actualMaxHourglassSum = Solution.maxHourglassSum(givenArray);

        Assertions.assertThat(actualMaxHourglassSum).isEqualTo(expectedMaxHourglassSum);
    }

    @ParameterizedTest
    @MethodSource("hourglasses")
    void testHourglassSum(int[][] givenArray, int expectedHourglassSum) {
        int actualHourglassSum = Solution.sumHourglass(givenArray, 0, 0);

        Assertions.assertThat(actualHourglassSum).isEqualTo(expectedHourglassSum);
    }
}
