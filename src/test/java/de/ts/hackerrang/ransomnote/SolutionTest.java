package de.ts.hackerrang.ransomnote;

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
                Arguments.of(new String[]{"give", "me", "one", "grand", "today", "night"}, new String[]{"give", "one", "grand", "today"}, "Yes"),
                Arguments.of(new String[]{"ive", "got", "a", "lovely", "bunch", "of", "coconuts"}, new String[]{"ive ", "got", "some", "coconuts"}, "No"),
                Arguments.of(new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two", "times", "two", "is", "four"}, "No")
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
    void checkMagazine(String[] givenMagazine, String[] givenNote, String expectedAnswer) {

        Solution.checkMagazine(givenMagazine, givenNote);

        String actualAnswer = testOutput.toString();

        Assertions.assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
