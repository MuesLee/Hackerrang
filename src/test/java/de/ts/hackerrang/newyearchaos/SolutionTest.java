package de.ts.hackerrang.newyearchaos;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

@ResourceLock(value = Resources.SYSTEM_OUT)
class SolutionTest {


    private PrintStream standardOutput;

    private PrintStream testPrintStream;
    private ByteArrayOutputStream testOutput;

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, "0" + System.lineSeparator()),
                Arguments.of(new int[]{2, 3, 4, 5, 1}, "4" + System.lineSeparator()),
                Arguments.of(new int[]{3, 2, 1}, "3" + System.lineSeparator()),
                Arguments.of(new int[]{2, 4, 3, 5, 1}, "5" + System.lineSeparator()),
                Arguments.of(new int[]{2, 1, 5, 3, 4}, "3" + System.lineSeparator()),
                Arguments.of(new int[]{2, 5, 1, 3, 4}, "Too chaotic" + System.lineSeparator()),
                Arguments.of(new int[]{5, 1, 2, 3, 7, 8, 6, 4}, "Too chaotic" + System.lineSeparator()),
                Arguments.of(new int[]{1, 2, 5, 3, 4, 7, 8, 6}, "4" + System.lineSeparator()),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7, 6, 8}, "1" + System.lineSeparator()),
                Arguments.of(new int[]{1, 2, 5, 3, 7, 8, 6, 4}, "7" + System.lineSeparator())
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
    void minimumBribes(int[] givenArray, String expectedResult) {
        Solution.minimumBribes(givenArray);

        String actualResult = testOutput.toString();

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
