package de.ts.hackerrang.arraymanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static long arrayManipulation(int n, int[][] queries) {

        Node root = new Node(null, 1, n, 0);

        for (int[] rangeAddOperation : queries) {

            int rangeStart = rangeAddOperation[0];
            int rangeEnd = rangeAddOperation[1];
            int addValue = rangeAddOperation[2];

            root.addIntervalValue(rangeStart, rangeEnd, addValue);
        }

        return root.getMaxSum();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static final class Node {

        int rangeStart;
        int rangeEnd;
        long maxSum;

        Node parent;

        Node leftChild;
        Node rightChild;

        public Node(Node parent, int rangeStart, int rangeEnd, long maxSum) {
            this.parent = parent;
            this.rangeStart = rangeStart;
            this.rangeEnd = rangeEnd;
            this.maxSum = maxSum;

            if (rangeStart > rangeEnd) {
                throw new IllegalArgumentException("rangeStart (" + rangeStart + ") must be greater than rangeEnd (" + rangeEnd + ")");
            }
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return Arrays.asList(leftChild, rightChild);
        }

        public boolean isLeaf() {
            if (leftChild == null && rightChild != null) throw new IllegalStateException();
            if (rightChild == null && leftChild != null) throw new IllegalStateException();

            return leftChild == null;
        }

        public int getRangeStart() {
            return rangeStart;
        }

        public void setRangeStart(int rangeStart) {
            this.rangeStart = rangeStart;
        }

        public int getRangeEnd() {
            return rangeEnd;
        }

        public void setRangeEnd(int rangeEnd) {
            this.rangeEnd = rangeEnd;
        }

        public long getMaxSum() {
            return maxSum;
        }

        public void setMaxSum(long maxSum) {
            this.maxSum = maxSum;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "rangeStart=" + rangeStart +
                    ", rangeEnd=" + rangeEnd +
                    ", maxSum=" + maxSum +
                    '}';
        }

        public long addIntervalValue(int rangeStart, int rangeEnd, long addValue) {
            if (this.rangeStart == rangeStart && this.rangeEnd == rangeEnd) {
                this.maxSum += addValue;
                return this.maxSum;
            }

            if (!this.isLeaf()) {
                if (rangeEnd > this.leftChild.getRangeEnd()) {
                    this.maxSum = Math.max(this.maxSum, this.rightChild.addIntervalValue(rangeStart, rangeEnd, addValue));
                } else {
                    this.maxSum = Math.max(this.maxSum, this.leftChild.addIntervalValue(rangeStart, rangeEnd, addValue));
                }

                return this.maxSum;
            }

            int oldRangeStart = this.rangeStart;
            int oldRangeEnd = this.rangeEnd;
            long oldMaxSum = this.maxSum;

            if (oldRangeStart > rangeEnd || oldRangeEnd < rangeStart) {

                this.rangeStart = Math.min(rangeStart, oldRangeStart);
                this.rangeEnd = Math.max(rangeEnd, oldRangeEnd);

                this.maxSum = Math.max(oldMaxSum, addValue);

                if (oldRangeStart < rangeStart) {
                    this.leftChild = new Node(this, oldRangeStart, oldRangeEnd, oldMaxSum);
                    this.rightChild = new Node(this, rangeStart, rangeEnd, addValue);
                } else {
                    this.rightChild = new Node(this, oldRangeStart, oldRangeEnd, oldMaxSum);
                    this.leftChild = new Node(this, rangeStart, rangeEnd, addValue);
                }

            }

            if (oldRangeStart == rangeStart && oldRangeEnd > rangeEnd) {
                this.leftChild = new Node(this, oldRangeStart, rangeEnd, oldMaxSum + addValue);
                this.rightChild = new Node(this, rangeEnd + 1, oldRangeEnd, oldMaxSum);
                this.maxSum = Math.max(oldMaxSum + addValue, addValue);
            }

            if (oldRangeStart < rangeStart && oldRangeEnd == rangeEnd) {
                this.leftChild = new Node(this, oldRangeStart, rangeStart - 1, oldMaxSum);
                this.rightChild = new Node(this, rangeStart, oldRangeEnd, oldMaxSum + addValue);
                this.maxSum = Math.max(oldMaxSum + addValue, addValue);
            }

            return this.maxSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return rangeStart == node.rangeStart &&
                    rangeEnd == node.rangeEnd &&
                    maxSum == node.maxSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rangeStart, rangeEnd, maxSum);
        }
    }
}
