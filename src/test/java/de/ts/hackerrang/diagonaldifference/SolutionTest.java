package de.ts.hackerrang.diagonaldifference;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest {

    @Test
    void diagonalDifference() {
        List<List<Integer>> givenMatrix = new ArrayList<>();
        givenMatrix.add(Arrays.asList(11, 2, 4));
        givenMatrix.add(Arrays.asList(4, 5, 6));
        givenMatrix.add(Arrays.asList(10, 8, -12));

        int actualDifference = Result.diagonalDifference(givenMatrix);

        Assertions.assertThat(actualDifference).isEqualTo(15);
    }
}
