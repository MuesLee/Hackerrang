package de.ts.hackerrang.minimaxsum;

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

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, "10 14"),
                Arguments.of(new int[]{256741038, 623958417, 467905213, 714532089, 938071625}, "2063136757 2744467344")
        );
    }


    @BeforeEach
    void setup() {
        standardOutput = System.out;
        testOutput = new ByteArrayOutputStream();
        testPrintStream = new PrintStream(testOutput);

        System.setOut(testPrintStream);
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    void miniMaxSum(int[] givenNumbers, String expectedMinMax) {
        String expectedMinMaxString = "2063136757 2744467344";

        Solution.miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});
        String actual = testOutput.toString();

        Assertions.assertThat(actual).isEqualTo(expectedMinMaxString);
    }

    @AfterEach
    void cleanUp() {
        testPrintStream.close();
        System.setOut(standardOutput);
    }
}
