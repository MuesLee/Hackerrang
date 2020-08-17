package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(10, new int[][]{
                }, 0),
                Arguments.of(10, new int[][]{
                        {1, 10, 3}
                }, 3),
                Arguments.of(10, new int[][]{
                        {1, 10, 3},
                        {1, 10, 2}
                }, 5),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {6, 10, 4}
                }, 5),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1}
                }, 10),
                Arguments.of(5, new int[][]{
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                }, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void arrayManipulation(int givenArrayLength, int[][] givenAddOperations, long expectedMaxValue) {
        long actual = Solution.arrayManipulation(givenArrayLength, givenAddOperations);
        Assertions.assertThat(actual).isEqualTo(expectedMaxValue);
    }

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
}
