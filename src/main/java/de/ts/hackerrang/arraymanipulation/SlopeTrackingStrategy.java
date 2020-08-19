package de.ts.hackerrang.arraymanipulation;

public class SlopeTrackingStrategy implements ArrayManipulationStrategy {

    @Override
    public long computeMaxSum(int n, int[][] queries) {

        long[] slopeStorage = new long[n];

        for (int[] slopeRange : queries) {
            int rangeStart = slopeRange[0];
            int rangeEnd = slopeRange[1];
            int slope = slopeRange[2];

            slopeStorage[rangeStart] += slope;
            if (rangeEnd + 1 < slopeStorage.length) {
                slopeStorage[rangeEnd + 1] -= slope;
            }
        }

        long maxValue = Long.MIN_VALUE;
        long currentValue = 0;

        for (long slope : slopeStorage) {
            currentValue += slope;

            maxValue = Math.max(currentValue, maxValue);
        }

        return maxValue;
    }
}
