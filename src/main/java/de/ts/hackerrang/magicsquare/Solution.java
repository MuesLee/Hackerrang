package de.ts.hackerrang.magicsquare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Complexity(1)
 * <p>
 * There is essentially just one possible 3x3 magic square,
 * which results in 8 possible forms through rotation and reflection.
 * <p>
 * This solution sums the differences of the given 3x3 square to the known 8 combinations
 * and finds the smallest one.
 */
public class Solution {

    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_1 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
    };
    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_2 = {
            {6, 1, 8},
            {7, 5, 3},
            {2, 9, 4}
    };
    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_3 = {
            {8, 3, 4},
            {1, 5, 9},
            {6, 7, 2}
    };
    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_4 = {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
    };

    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_5 = {
            {4, 3, 8},
            {9, 5, 1},
            {2, 7, 6}
    };

    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_6 = {
            {6, 7, 2},
            {1, 5, 9},
            {8, 3, 4}
    };
    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_7 = {
            {2, 9, 4},
            {7, 5, 3},
            {6, 1, 8}
    };

    private static final int[][] POSSIBLE_MAGIC_SQUARE_FORM_8 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
    };

    static final List<int[][]> ALL_POSSIBLE_MAGIC_SQUARE_FORMS = Arrays.asList(
            POSSIBLE_MAGIC_SQUARE_FORM_1, POSSIBLE_MAGIC_SQUARE_FORM_2,
            POSSIBLE_MAGIC_SQUARE_FORM_3, POSSIBLE_MAGIC_SQUARE_FORM_4,
            POSSIBLE_MAGIC_SQUARE_FORM_5, POSSIBLE_MAGIC_SQUARE_FORM_6,
            POSSIBLE_MAGIC_SQUARE_FORM_7, POSSIBLE_MAGIC_SQUARE_FORM_8);
    private static final Scanner scanner = new Scanner(System.in);

    static int formingMagicSquare(int[][] s) {

        int minDiff = Integer.MAX_VALUE;

        for (int[][] possibleMagicSquareForm : ALL_POSSIBLE_MAGIC_SQUARE_FORMS) {
            int totalDiffToForm = 0;

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[0].length; j++) {
                    totalDiffToForm += Math.abs(s[i][j] - possibleMagicSquareForm[i][j]);
                }
            }
            minDiff = Math.min(minDiff, totalDiffToForm);
        }

        return minDiff;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
