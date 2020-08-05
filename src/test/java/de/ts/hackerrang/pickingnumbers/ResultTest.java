package de.ts.hackerrang.pickingnumbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class ResultTest {

    private static Stream<Arguments> puzzleArguments() {

        return Stream.of(Arguments.of(
                Collections.emptyList(), 0),
                Arguments.of(
                        Collections.singletonList(1), 1),
                Arguments.of(
                        Arrays.asList(4, 6, 5, 3, 3, 1), 3),
                Arguments.of(
                        Arrays.asList(1, 2, 2, 3, 1, 2), 5),
                Arguments.of(
                        Arrays.asList(1, 1, 2, 2, 3, 3, 3), 5),
                Arguments.of(
                        Arrays.asList(1, 1, 5, 5, 5, 5, 5, 5, 6, 8, 8, 8, 8, 9, 9, 9, 9), 8),
                Arguments.of(
                        Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 6, 8, 8, 8, 8, 9, 9, 9, 9), 8),
                Arguments.of(
                        Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 6, 8, 8, 8), 8)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void pickingNumbers(List<Integer> givenNumbers, int expected) {

        int actual = Result.pickingNumbers(givenNumbers);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
