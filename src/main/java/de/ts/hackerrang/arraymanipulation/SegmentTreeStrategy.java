package de.ts.hackerrang.arraymanipulation;

class SegmentTreeStrategy implements ArrayManipulationStrategy {

    @Override
    public long computeMaxSum(int n, int[][] queries) {
        SegmentNode root = new SegmentNode(null, 1, n, 0);

        for (int[] rangeAddOperation : queries) {

            int rangeStart = rangeAddOperation[0];
            int rangeEnd = rangeAddOperation[1];
            int addValue = rangeAddOperation[2];

            root.addIntervalValue(rangeStart, rangeEnd, addValue);
        }

        return root.getMaxSum();
    }
}
