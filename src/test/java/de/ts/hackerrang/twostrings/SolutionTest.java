package de.ts.hackerrang.twostrings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of("hello", "world", "YES"),
                Arguments.of("hi", "world", "NO")
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void twoStrings(String firstString, String secondString, String expectedResult) {
        String actualResult = Solution.twoStrings(firstString, secondString);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

    }
}
