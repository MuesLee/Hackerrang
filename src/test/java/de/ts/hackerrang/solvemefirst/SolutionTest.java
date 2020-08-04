package de.ts.hackerrang.solvemefirst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solveMeFirst() {

        int actual = Solution.solveMeFirst(3, 5);

        Assertions.assertThat(actual).isEqualTo(8);
    }
}
