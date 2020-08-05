package de.ts.hackerrang.magicsquare;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> puzzleArguments() {
        return Stream.of(Arguments.of(new int[][]{
                        {2, 7, 6},
                        {9, 5, 1},
                        {4, 3, 8}
                }, 0),
                Arguments.of(new int[][]{
                        {4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 5}
                }, 1),
                Arguments.of(new int[][]{
                        {4, 8, 2},
                        {4, 5, 7},
                        {6, 1, 6}
                }, 4),
                Arguments.of(new int[][]{
                        {5, 3, 4},
                        {1, 5, 8},
                        {6, 4, 2}
                }, 7)

        );
    }

    private static Stream<int[][]> allPossibleMagicSquares() {
        return Solution.ALL_POSSIBLE_MAGIC_SQUARE_FORMS.stream();
    }


    @ParameterizedTest(name = "{index}: transforming {0} should have min cost of {1}")
    @MethodSource("puzzleArguments")
    void magicSquareSolution(int[][] givenNumbers, int expectedScore) {

        int actualScore = Solution.formingMagicSquare(givenNumbers);

        Assertions.assertThat(actualScore).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "{index}: {0} should be a valid 3x3 magic square")
    @MethodSource("allPossibleMagicSquares")
    void allPossibleMagicSquaresShouldBeValid(int[][] givenSquare) {
        int row1Sum = givenSquare[0][0] + givenSquare[0][1] + givenSquare[0][2];
        int row2Sum = givenSquare[1][0] + givenSquare[1][1] + givenSquare[1][2];
        int row3Sum = givenSquare[2][0] + givenSquare[2][1] + givenSquare[2][2];

        int col1Sum = givenSquare[0][0] + givenSquare[1][0] + givenSquare[2][0];
        int col2Sum = givenSquare[0][1] + givenSquare[1][1] + givenSquare[2][1];
        int col3Sum = givenSquare[0][2] + givenSquare[1][2] + givenSquare[2][2];

        int diagSum1 = givenSquare[0][0] + givenSquare[1][1] + givenSquare[2][2];
        int diagSum2 = givenSquare[0][2] + givenSquare[1][1] + givenSquare[2][0];

        Assertions.assertThat(diagSum1).as("The sum of all numbers from top-left to bot-right should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);
        Assertions.assertThat(diagSum2).as("The sum of all numbers from top-right to bot-left should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);

        Assertions.assertThat(col1Sum).as("The sum of the first column should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);
        Assertions.assertThat(col2Sum).as("The sum of the second column should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);
        Assertions.assertThat(col3Sum).as("The sum of the third column should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);

        Assertions.assertThat(row1Sum).as("The sum of the first row should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);
        Assertions.assertThat(row2Sum).as("The sum of the second row should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);
        Assertions.assertThat(row3Sum).as("The sum of the third row should be equal to the magic constant, which is 15 for 3x3 magic squares").isEqualTo(15);

        int[] actualDistinctNumbers = Arrays.stream(givenSquare).flatMapToInt(Arrays::stream).distinct().toArray();
        Assertions.assertThat(actualDistinctNumbers).as("The 3x3 magic square should contain each number from 1-9 exactly once").containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
