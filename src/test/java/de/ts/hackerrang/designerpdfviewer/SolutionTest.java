package de.ts.hackerrang.designerpdfviewer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "", 0),
                Arguments.of(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc", 9),
                Arguments.of(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "zaba", 28)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void designerPdfViewer(int[] characterHeights, String word, int expectedAreaSizeInMm) {

        int actualAreaSizeInMm = Solution.designerPdfViewer(characterHeights, word);

        Assertions.assertThat(actualAreaSizeInMm).isEqualTo(expectedAreaSizeInMm);
    }

}
