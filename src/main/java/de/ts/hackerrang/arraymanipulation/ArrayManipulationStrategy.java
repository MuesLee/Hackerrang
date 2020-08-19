package de.ts.hackerrang.arraymanipulation;

interface ArrayManipulationStrategy {

    long computeMaxSum(int n, int[][] queries);

    default long solve(ProblemDefinition definition) {
        return computeMaxSum(definition.getArrayLength(), definition.getIntervalSums());
    }
}
