package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SegmentNodeTest {


    /**
     * Existing interval:   |-------|
     * New interval:        |-------|
     */
    @Test
    void givenLeafNodeWhenAddingIdenticalIntervalThenShouldShouldIncreaseItsOwnMaxSum() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 5, 1);
        givenLeafNode.addIntervalValue(1, 5, 5);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(5);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(6);

        Assertions.assertThat(givenLeafNode.isLeaf()).isTrue();
    }

    /**
     * Existing interval:   |-------|
     * New interval:                 |---|
     */
    @Test
    void givenLeafNodeWhenAddingGreaterNotIntersectingIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 5, 1);
        givenLeafNode.addIntervalValue(6, 10, 5);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 5, 1);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 6, 10, 5);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(5);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }

    /**
     * Existing interval:      |-------|
     * New interval:     |---|
     */
    @Test
    void givenLeafNodeWhenAddingLesserNotIntersectingIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 5, 10, 1);
        givenLeafNode.addIntervalValue(1, 3, 5);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 3, 5);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 5, 10, 1);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(5);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }


    /**
     * Existing interval:   |-------|
     * New interval:        |---|
     */
    @Test
    void givenLeafNodeWhenAddingLeftAlignedIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 10, 1);
        givenLeafNode.addIntervalValue(1, 5, 5);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 5, 6);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 6, 10, 1);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(6);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }

    /**
     * Existing interval:   |-------|
     * New interval:            |---|
     */
    @Test
    void givenLeafNodeWhenAddingRightAlignedIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 10, 1);
        givenLeafNode.addIntervalValue(5, 10, 7);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 4, 1);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 5, 10, 8);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(8);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }

    /**
     * Existing interval:   |----|
     * New interval:        |-------|
     */
    @Test
    void givenLeafNodeWhenAddingRightOverlappingIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 5, 1);
        givenLeafNode.addIntervalValue(1, 10, 7);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 5, 8);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 6, 10, 7);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(8);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }

    /**
     * Existing interval:      |----|
     * New interval:        |-------|
     */
    @Test
    void givenLeafNodeWhenAddingLeftOverlappingIntervalThenShouldSplitItSelfIntoTwoChildren() {
        SegmentNode givenLeafNode = new SegmentNode(null, 5, 10, 5);
        givenLeafNode.addIntervalValue(1, 10, 7);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 4, 7);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 5, 10, 12);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(12);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
    }

    /**
     * Existing interval:  |-----------|
     * New interval:         |------|
     */
    @Test
    void givenLeafNodeWhenFullyContainableIntervalThenShouldSplitItSelfIntoTwoChildrenAndLeftChildrenIntoTwo() {
        SegmentNode givenLeafNode = new SegmentNode(null, 1, 10, 5);
        givenLeafNode.addIntervalValue(5, 7, 7);

        SegmentNode expectedFirstChildren = new SegmentNode(givenLeafNode, 1, 7, 12);
        SegmentNode expectedSecondChildren = new SegmentNode(givenLeafNode, 8, 10, 5);
        SegmentNode expectedThirdChildren = new SegmentNode(givenLeafNode, 1, 4, 5);
        SegmentNode expectedFourthChildren = new SegmentNode(givenLeafNode, 5, 7, 12);

        Assertions.assertThat(givenLeafNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenLeafNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenLeafNode.getMaxSum()).isEqualTo(12);

        Assertions.assertThat(givenLeafNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenLeafNode.getRightChild()).isEqualTo(expectedSecondChildren);
        Assertions.assertThat(givenLeafNode.getLeftChild().getLeftChild()).isEqualTo(expectedThirdChildren);
        Assertions.assertThat(givenLeafNode.getLeftChild().getRightChild()).isEqualTo(expectedFourthChildren);
    }


    /**
     * Existing interval:   |-------|
     * New interval:            |---|
     */
    @Test
    void givenRootNodeWhenAddingRightAlignedIntervalThenShouldSplitRightChildIntoTwoChildren() {
        SegmentNode givenRootNode = new SegmentNode(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(8, 10, 3);


        SegmentNode expectedFirstChildren = new SegmentNode(givenRootNode, 1, 5, 1);
        SegmentNode expectedSecondChildren = new SegmentNode(givenRootNode, 6, 10, 10);

        SegmentNode expectedThirdChildren = new SegmentNode(givenRootNode, 6, 7, 7);
        SegmentNode expectedFourthChildren = new SegmentNode(givenRootNode, 8, 10, 10);

        Assertions.assertThat(givenRootNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenRootNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenRootNode.getMaxSum()).isEqualTo(10);

        Assertions.assertThat(givenRootNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenRootNode.getRightChild()).isEqualTo(expectedSecondChildren);

        Assertions.assertThat(givenRootNode.getLeftChild().isLeaf()).isTrue();

        Assertions.assertThat(givenRootNode.getRightChild().getLeftChild()).isEqualTo(expectedThirdChildren);
        Assertions.assertThat(givenRootNode.getRightChild().getRightChild()).isEqualTo(expectedFourthChildren);
    }


    /**
     * Existing interval:   |-------|
     * New interval:        |---|
     */
    @Test
    void givenRootNodeWhenAddingLeftAlignedIntervalThenShouldSplitLeftChildIntoTwoChildren() {
        SegmentNode givenRootNode = new SegmentNode(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(2, 5, 3);

        SegmentNode expectedFirstChildren = new SegmentNode(givenRootNode, 1, 5, 4);
        SegmentNode expectedSecondChildren = new SegmentNode(givenRootNode, 6, 10, 7);

        SegmentNode expectedThirdChildren = new SegmentNode(givenRootNode, 1, 1, 1);
        SegmentNode expectedForthChildren = new SegmentNode(givenRootNode, 2, 5, 4);

        Assertions.assertThat(givenRootNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenRootNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenRootNode.getMaxSum()).isEqualTo(7);

        Assertions.assertThat(givenRootNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenRootNode.getRightChild()).isEqualTo(expectedSecondChildren);

        Assertions.assertThat(givenRootNode.getRightChild().isLeaf()).isTrue();

        Assertions.assertThat(givenRootNode.getLeftChild().getLeftChild()).isEqualTo(expectedThirdChildren);
        Assertions.assertThat(givenRootNode.getLeftChild().getRightChild()).isEqualTo(expectedForthChildren);
    }

    /**
     * Existing interval:   |-------|
     * New interval:        |-------|
     */
    @Test
    void givenRootNodeWhenAddingIdenticalIntervalThenShouldUpdateAllChildren() {
        SegmentNode givenRootNode = new SegmentNode(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(1, 10, 3);

        SegmentNode expectedFirstChildren = new SegmentNode(givenRootNode, 1, 5, 4);
        SegmentNode expectedSecondChildren = new SegmentNode(givenRootNode, 6, 10, 10);

        Assertions.assertThat(givenRootNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenRootNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenRootNode.getMaxSum()).isEqualTo(10);

        Assertions.assertThat(givenRootNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenRootNode.getRightChild()).isEqualTo(expectedSecondChildren);

        Assertions.assertThat(givenRootNode.getRightChild().isLeaf()).isTrue();
    }

    /**
     * Existing interval:   |---|  |----|
     * New interval:        |-----------|
     */
    @Test
    void givenRootNodeWithIntervalGapWhenAddingOverspanningIntervalThenShouldSplitRightChildIntoTwoChildren() {
        SegmentNode givenRootNode = new SegmentNode(null, 1, 5, 1);
        givenRootNode.addIntervalValue(8, 10, 7);

        givenRootNode.addIntervalValue(1, 10, 3);

        SegmentNode expectedFirstChildren = new SegmentNode(givenRootNode, 1, 5, 4);
        SegmentNode expectedSecondChildren = new SegmentNode(givenRootNode, 6, 10, 10);

        SegmentNode expectedThirdChildren = new SegmentNode(givenRootNode, 6, 7, 3);
        SegmentNode expectedForthChildren = new SegmentNode(givenRootNode, 8, 10, 10);

        Assertions.assertThat(givenRootNode.getRangeStart()).isEqualTo(1);
        Assertions.assertThat(givenRootNode.getRangeEnd()).isEqualTo(10);
        Assertions.assertThat(givenRootNode.getMaxSum()).isEqualTo(10);

        Assertions.assertThat(givenRootNode.getLeftChild()).isEqualTo(expectedFirstChildren);
        Assertions.assertThat(givenRootNode.getRightChild()).isEqualTo(expectedSecondChildren);

        Assertions.assertThat(givenRootNode.getLeftChild().isLeaf()).isTrue();

        Assertions.assertThat(givenRootNode.getRightChild().getLeftChild()).isEqualTo(expectedThirdChildren);
        Assertions.assertThat(givenRootNode.getRightChild().getRightChild()).isEqualTo(expectedForthChildren);
    }
}
