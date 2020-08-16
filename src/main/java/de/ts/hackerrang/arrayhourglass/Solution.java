package de.ts.hackerrang.arrayhourglass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int maxHourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - 3; i++) {
            for (int j = 0; j <= arr[i].length - 3; j++) {
                maxSum = Math.max(maxSum, sumHourglass(arr, i, j));
            }
        }

        return maxSum;
    }

    static int sumHourglass(int[][] array, int startX, int startY) {

        int sum = 0;

        sum += array[startX][startY];
        sum += array[startX][startY + 1];
        sum += array[startX][startY + 2];

        sum += array[startX + 1][startY + 1];

        sum += array[startX + 2][startY];
        sum += array[startX + 2][startY + 1];
        sum += array[startX + 2][startY + 2];

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = maxHourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
