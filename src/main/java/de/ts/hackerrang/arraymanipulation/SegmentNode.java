package de.ts.hackerrang.arraymanipulation;

import java.util.Objects;

final class SegmentNode {

    final SegmentNode parent;
    int rangeStart;
    int rangeEnd;
    long maxSum;
    SegmentNode leftChild;
    SegmentNode rightChild;

    public SegmentNode(SegmentNode parent, int rangeStart, int rangeEnd, long maxSum) {
        this.parent = parent;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.maxSum = maxSum;

        if (rangeStart > rangeEnd) {
            throw new IllegalArgumentException("rangeStart (" + rangeStart + ") must be greater than rangeEnd (" + rangeEnd + ")");
        }
    }

    public boolean isLeaf() {
        if (leftChild == null && rightChild != null) throw new IllegalStateException();
        if (rightChild == null && leftChild != null) throw new IllegalStateException();

        return leftChild == null;
    }

    public int getRangeStart() {
        return rangeStart;
    }


    public int getRangeEnd() {
        return rangeEnd;
    }


    public long getMaxSum() {
        return maxSum;
    }


    public SegmentNode getLeftChild() {
        return leftChild;
    }

    public SegmentNode getRightChild() {
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
        if (!this.isLeaf()) {
            if (rangeEnd <= this.leftChild.rangeEnd) {
                this.maxSum = Math.max(this.maxSum, this.leftChild.addIntervalValue(rangeStart, rangeEnd, addValue));
            } else if (rangeStart >= this.rightChild.rangeStart) {
                this.maxSum = Math.max(this.maxSum, this.rightChild.addIntervalValue(rangeStart, rangeEnd, addValue));
            } else {
                this.maxSum = Math.max(this.maxSum, this.leftChild.addIntervalValue(rangeStart, this.leftChild.rangeEnd, addValue));
                this.maxSum = Math.max(this.maxSum, this.rightChild.addIntervalValue(this.leftChild.rangeEnd + 1, rangeEnd, addValue));
            }

            this.rangeStart = Math.min(this.rangeStart, rangeStart);
            this.rangeEnd = Math.max(this.rangeEnd, rangeEnd);

            return this.maxSum;
        }

        if (this.rangeStart == rangeStart && this.rangeEnd == rangeEnd) {
            this.maxSum += addValue;
            return this.maxSum;
        }

        int oldRangeStart = this.rangeStart;
        int oldRangeEnd = this.rangeEnd;
        long oldMaxSum = this.maxSum;

        boolean hasSameStart = rangeStart == oldRangeStart;
        boolean hasSameEnd = oldRangeEnd == rangeEnd;

        boolean newIntervalStartsAfterOld = oldRangeStart < rangeStart;
        boolean newIntervalEndsBeforeOld = oldRangeEnd > rangeEnd;

        boolean newIntervalEndsLeftOfOld = oldRangeStart > rangeEnd;
        boolean newIntervalStartsRightOfOld = oldRangeEnd < rangeStart;

        if (newIntervalEndsLeftOfOld || newIntervalStartsRightOfOld) {

            this.rangeStart = Math.min(rangeStart, oldRangeStart);
            this.rangeEnd = Math.max(rangeEnd, oldRangeEnd);

            this.maxSum = Math.max(oldMaxSum, addValue);

            if (newIntervalStartsAfterOld) {
                this.leftChild = new SegmentNode(this, oldRangeStart, oldRangeEnd, oldMaxSum);
                this.rightChild = new SegmentNode(this, rangeStart, rangeEnd, addValue);
            } else {
                this.rightChild = new SegmentNode(this, oldRangeStart, oldRangeEnd, oldMaxSum);
                this.leftChild = new SegmentNode(this, rangeStart, rangeEnd, addValue);
            }
            return this.maxSum;
        }


        if (hasSameStart && newIntervalEndsBeforeOld) {
            this.leftChild = new SegmentNode(this, oldRangeStart, rangeEnd, oldMaxSum + addValue);
            this.rightChild = new SegmentNode(this, rangeEnd + 1, oldRangeEnd, oldMaxSum);
        }

        if (newIntervalStartsAfterOld && hasSameEnd) {
            this.leftChild = new SegmentNode(this, oldRangeStart, rangeStart - 1, oldMaxSum);
            this.rightChild = new SegmentNode(this, rangeStart, oldRangeEnd, oldMaxSum + addValue);
        }

        if (hasSameStart && rangeEnd > oldRangeEnd) {
            this.leftChild = new SegmentNode(this, rangeStart, oldRangeEnd, addValue + oldMaxSum);
            this.rightChild = new SegmentNode(this, oldRangeEnd + 1, rangeEnd, addValue);
        }
        if (hasSameStart && rangeEnd < oldRangeEnd) {
            this.leftChild = new SegmentNode(this, rangeStart, rangeEnd, addValue + oldMaxSum);
            this.rightChild = new SegmentNode(this, rangeEnd + 1, oldRangeEnd, oldMaxSum);
        }
        if (hasSameEnd && rangeStart < oldRangeStart) {
            this.leftChild = new SegmentNode(this, rangeStart, oldRangeStart - 1, addValue);
            this.rightChild = new SegmentNode(this, oldRangeStart, oldRangeEnd, oldMaxSum + addValue);
        }
        if (newIntervalStartsAfterOld && newIntervalEndsBeforeOld) {
            this.leftChild = new SegmentNode(this, oldRangeStart, rangeStart - 1, oldMaxSum);
            this.rightChild = new SegmentNode(this, rangeEnd + 1, oldRangeEnd, oldMaxSum);

            this.leftChild.addIntervalValue(rangeStart, rangeEnd, addValue + oldMaxSum);
        }

        this.rangeStart = Math.min(rangeStart, oldRangeStart);
        this.rangeEnd = Math.max(rangeEnd, oldRangeEnd);
        this.maxSum = Math.max(oldMaxSum + addValue, addValue);

        return this.maxSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SegmentNode)) return false;
        SegmentNode node = (SegmentNode) o;
        return rangeStart == node.rangeStart &&
                rangeEnd == node.rangeEnd &&
                maxSum == node.maxSum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rangeStart, rangeEnd, maxSum);
    }
}
