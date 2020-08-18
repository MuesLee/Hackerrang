package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(10, new int[][]{
                }, 0),
                Arguments.of(10, new int[][]{
                        {1, 10, 3}
                }, 3),
                Arguments.of(10, new int[][]{
                        {1, 10, 3},
                        {1, 10, 2}
                }, 5),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {6, 10, 4}
                }, 4),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1}
                }, 10),
                Arguments.of(5, new int[][]{
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                }, 200),
                Arguments.of(10, new int[][]{
                        {2, 6, 8},
                        {3, 5, 7},
                        {1, 8, 1},
                        {5, 9, 15}
                }, 31)
        );
    }

    private static Stream<Arguments> performanceArguments() {
        return Stream.of(
                Arguments.arguments("/arraymanipulation/arraymanipulation_1000000_operations_1.txt", 2510535321L),
                Arguments.arguments("/arraymanipulation/arraymanipulation_1000000_operations_2.txt", 2497169732L)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    @Timeout(1)
    void arrayManipulation(int givenArrayLength, int[][] givenAddOperations, long expectedMaxValue) {
        long actual = Solution.arrayManipulation(givenArrayLength, givenAddOperations);
        Assertions.assertThat(actual).isEqualTo(expectedMaxValue);
    }

    @ParameterizedTest
    @MethodSource("performanceArguments")
    void arrayManipulationPerformanceTest(String filePath, long expectedResult) {

        Scanner scanner = new Scanner(Solution.class.getResourceAsStream(filePath));

        long actual = Solution.parseAndExecuteArrayManipulation(scanner);

        Assertions.assertThat(actual).isEqualTo(expectedResult);
    }
}
