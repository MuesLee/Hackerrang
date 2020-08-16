package de.ts.hackerrang.repeatedstring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of("aba", 10L, 7L),
                Arguments.of("a", 1000000000000L, 1000000000000L)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void repeatedString(String givenSequence, long relevantCharacterCount, long expectedCountOfA) {

        long actualCountOfA = Solution.repeatedString(givenSequence, relevantCharacterCount);

        Assertions.assertThat(actualCountOfA).isEqualTo(expectedCountOfA);
    }
}
