package de.ts.hackerrang.minimumswaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int minimumSwaps(int[] arr) {

        int swapCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int actualNumber = arr[i];
            int expectedNumber = i + 1;
            if (actualNumber != expectedNumber) {
                boolean perfectSwap = tryPerfectSwap(arr, i, actualNumber, expectedNumber);
                if (!perfectSwap) {
                    swapActualNumberIntoItsPlace(arr, actualNumber, i);
                    i--;
                }
                swapCount++;
            }
        }


        return swapCount;
    }

    private static void swapActualNumberIntoItsPlace(int[] arr, int actualNumber, int indexOfActualNumber) {
        int t = arr[actualNumber - 1];
        arr[actualNumber - 1] = actualNumber;
        arr[indexOfActualNumber] = t;
    }

    private static boolean tryPerfectSwap(int[] arr, int startingIndex, int actualNumber, int expectedNumber) {
        for (int j = startingIndex + 1; j < arr.length; j++) {
            if (arr[actualNumber - 1] == expectedNumber) {
                arr[actualNumber - 1] = actualNumber;
                arr[startingIndex] = expectedNumber;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
