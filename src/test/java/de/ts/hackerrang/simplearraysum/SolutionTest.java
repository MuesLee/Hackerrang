package de.ts.hackerrang.simplearraysum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void simpleArraySum() {
        int actual = Solution.simpleArraySum(new int[]{1, 2, 3, 4, 10, 11});

        Assertions.assertThat(actual).isEqualTo(31);
    }
}
