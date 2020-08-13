package de.ts.hackerrang.dayoftheprogrammer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(2017, "13.09.2017"),
                Arguments.of(2016, "12.09.2016"),
                Arguments.of(1800, "12.09.1800"),
                Arguments.of(1880, "12.09.1880"),
                Arguments.of(1915, "13.09.1915"),
                Arguments.of(1918, "26.09.1918")
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void dayOfProgrammer(int givenYear, String expectedDate) {
        String actualDate = Solution.dayOfProgrammer(givenYear);
        Assertions.assertThat(actualDate).isEqualTo(expectedDate);
    }
}
