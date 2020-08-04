package de.ts.hackerrang.timeconversion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("07:05:45PM", "19:05:45"),
                Arguments.of("00:05:45AM", "00:05:45"),
                Arguments.of("12:05:45PM", "12:05:45")
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    void timeConversion(String given12hourTime, String expectedMilitaryTime) {
        String actualMilitaryTime = Solution.timeConversion(given12hourTime);

        Assertions.assertThat(actualMilitaryTime).isEqualTo(expectedMilitaryTime);
    }
}
