package de.ts.hackerrang.arraymanipulation;

public class ProblemDefinition {

    private final int arrayLength;
    private final int[][] intervalSums;

    public ProblemDefinition(int arrayLength, int[][] intervalSums) {
        this.arrayLength = arrayLength;
        this.intervalSums = intervalSums;
    }

    public int[][] getIntervalSums() {
        return intervalSums;
    }

    public int getArrayLength() {
        return arrayLength;
    }
}
