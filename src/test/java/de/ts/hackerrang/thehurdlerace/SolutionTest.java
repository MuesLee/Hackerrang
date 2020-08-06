package de.ts.hackerrang.thehurdlerace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {


    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(0, new int[]{0}, 0),
                Arguments.of(1, new int[]{0}, 0),
                Arguments.of(1, new int[]{}, 0),
                Arguments.of(2, new int[]{1, 2, 3, 4, 1, 2, 3}, 2),
                Arguments.of(4, new int[]{1, 6, 3, 5, 2}, 2),
                Arguments.of(7, new int[]{2, 5, 4, 5, 2}, 0)
        );
    }

    @ParameterizedTest(name = "{index}: Dan can naturally jump {0} units high. He needs {2} potions to cross {1}")
    @MethodSource("puzzleArguments")
    void hurdleRace(int k, int[] height, int expected) {

        int actual = Solution.hurdleRace(k, height);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
