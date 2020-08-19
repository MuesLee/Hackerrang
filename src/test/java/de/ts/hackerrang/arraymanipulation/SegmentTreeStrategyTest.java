package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
class SegmentTreeStrategyTest {

    private final SegmentTreeStrategy classUnderTest = new SegmentTreeStrategy();

    private static Stream<Arguments> puzzleArguments() {
        return TestData.puzzleArguments();
    }

    private static Stream<Arguments> performanceArguments() {
        return TestData.performanceArguments();
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    @Timeout(1)
    void arrayManipulation(int givenArrayLength, int[][] givenAddOperations, long expectedMaxValue) {
        long actual = classUnderTest.computeMaxSum(givenArrayLength, givenAddOperations);
        Assertions.assertThat(actual).isEqualTo(expectedMaxValue);
    }

    @ParameterizedTest
    @MethodSource("performanceArguments")
    @EnabledIfSystemProperty(named = "longTests", matches = "true")
    void arrayManipulationPerformanceTest(String filePath, long expectedResult) {

        Scanner scanner = new Scanner(Solution.class.getResourceAsStream(filePath));

        ProblemDefinition problemDefinition = Solution.parseProblemDefinition(scanner);
        long actual = classUnderTest.solve(problemDefinition);

        Assertions.assertThat(actual).isEqualTo(expectedResult);
    }
}
