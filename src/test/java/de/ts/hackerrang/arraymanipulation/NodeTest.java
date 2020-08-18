package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeTest {


    /**
     * Existing interval:   |-------|
     * New interval:        |-------|
     */
    @Test
    void givenLeafNodeWhenAddingIdenticalIntervalThenShouldShouldIncreaseItsOwnMaxSum() {
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 5, 1);
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
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 5, 1);
        givenLeafNode.addIntervalValue(6, 10, 5);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 5, 1);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 6, 10, 5);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 5, 10, 1);
        givenLeafNode.addIntervalValue(1, 3, 5);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 3, 5);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 5, 10, 1);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 10, 1);
        givenLeafNode.addIntervalValue(1, 5, 5);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 5, 6);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 6, 10, 1);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 10, 1);
        givenLeafNode.addIntervalValue(5, 10, 7);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 4, 1);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 5, 10, 8);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 5, 1);
        givenLeafNode.addIntervalValue(1, 10, 7);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 5, 8);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 6, 10, 7);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 5, 10, 5);
        givenLeafNode.addIntervalValue(1, 10, 7);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 4, 7);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 5, 10, 12);

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
        Solution.Node givenLeafNode = new Solution.Node(null, 1, 10, 5);
        givenLeafNode.addIntervalValue(5, 7, 7);

        Solution.Node expectedFirstChildren = new Solution.Node(givenLeafNode, 1, 7, 12);
        Solution.Node expectedSecondChildren = new Solution.Node(givenLeafNode, 8, 10, 5);
        Solution.Node expectedThirdChildren = new Solution.Node(givenLeafNode, 1, 4, 5);
        Solution.Node expectedFourthChildren = new Solution.Node(givenLeafNode, 5, 7, 12);

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
        Solution.Node givenRootNode = new Solution.Node(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(8, 10, 3);


        Solution.Node expectedFirstChildren = new Solution.Node(givenRootNode, 1, 5, 1);
        Solution.Node expectedSecondChildren = new Solution.Node(givenRootNode, 6, 10, 10);

        Solution.Node expectedThirdChildren = new Solution.Node(givenRootNode, 6, 7, 7);
        Solution.Node expectedFourthChildren = new Solution.Node(givenRootNode, 8, 10, 10);

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
        Solution.Node givenRootNode = new Solution.Node(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(2, 5, 3);

        Solution.Node expectedFirstChildren = new Solution.Node(givenRootNode, 1, 5, 4);
        Solution.Node expectedSecondChildren = new Solution.Node(givenRootNode, 6, 10, 7);

        Solution.Node expectedThirdChildren = new Solution.Node(givenRootNode, 1, 1, 1);
        Solution.Node expectedForthChildren = new Solution.Node(givenRootNode, 2, 5, 4);

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
        Solution.Node givenRootNode = new Solution.Node(null, 1, 5, 1);
        givenRootNode.addIntervalValue(6, 10, 7);

        givenRootNode.addIntervalValue(1, 10, 3);

        Solution.Node expectedFirstChildren = new Solution.Node(givenRootNode, 1, 5, 4);
        Solution.Node expectedSecondChildren = new Solution.Node(givenRootNode, 6, 10, 10);

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
        Solution.Node givenRootNode = new Solution.Node(null, 1, 5, 1);
        givenRootNode.addIntervalValue(8, 10, 7);

        givenRootNode.addIntervalValue(1, 10, 3);

        Solution.Node expectedFirstChildren = new Solution.Node(givenRootNode, 1, 5, 4);
        Solution.Node expectedSecondChildren = new Solution.Node(givenRootNode, 6, 10, 10);

        Solution.Node expectedThirdChildren = new Solution.Node(givenRootNode, 6, 7, 3);
        Solution.Node expectedForthChildren = new Solution.Node(givenRootNode, 8, 10, 10);

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
