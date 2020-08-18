package de.ts.hackerrang.staircase;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@ResourceLock(value = Resources.SYSTEM_OUT)
class SolutionTest {


    private PrintStream standardOutput;

    private PrintStream testPrintStream;
    private ByteArrayOutputStream testOutput;


    @BeforeEach
    void setup() {
        standardOutput = System.out;
        testOutput = new ByteArrayOutputStream();
        testPrintStream = new PrintStream(testOutput);

        System.setOut(testPrintStream);
    }

    @Test
    void staircase() {
        String expectedStaircase =
                "     #" + System.lineSeparator() +
                        "    ##" + System.lineSeparator() +
                        "   ###" + System.lineSeparator() +
                        "  ####" + System.lineSeparator() +
                        " #####" + System.lineSeparator() +
                        "######";

        Solution.staircase(6);
        String actual = testOutput.toString();

        Assertions.assertThat(actual).isEqualTo(expectedStaircase);
    }

    @AfterEach
    void cleanUp() {
        testPrintStream.close();
        System.setOut(standardOutput);
    }
}
