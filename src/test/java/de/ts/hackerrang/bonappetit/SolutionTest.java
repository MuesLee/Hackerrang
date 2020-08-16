package de.ts.hackerrang.bonappetit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private PrintStream standardOutput;

    private PrintStream testPrintStream;
    private ByteArrayOutputStream testOutput;

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 10, 2, 9), 1, 12, "5"),
                Arguments.of(Arrays.asList(3, 10, 2, 9), 1, 7, "Bon Appetit")
        );
    }


    @BeforeEach
    void setup() {
        standardOutput = System.out;
        testOutput = new ByteArrayOutputStream();
        testPrintStream = new PrintStream(testOutput);

        System.setOut(testPrintStream);
    }

    @AfterEach
    void cleanUp() {
        testPrintStream.close();
        System.setOut(standardOutput);
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void bonAppetit(List<Integer> givenMealCosts, int skippedMealIndex, int calculatedShare, String expectedOutput) {
        Solution.bonAppetit(givenMealCosts, skippedMealIndex, calculatedShare);
        String actualOutput = testOutput.toString();
        Assertions.assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
