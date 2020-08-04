package de.ts.hackerrang.averybigsum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    void aVeryBigSum() {
        long actual = Solution.aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005});

        Assertions.assertThat(actual).isEqualTo(5000000015L);
    }
}
