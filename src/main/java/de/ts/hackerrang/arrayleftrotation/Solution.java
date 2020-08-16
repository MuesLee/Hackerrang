package de.ts.hackerrang.arrayleftrotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] rotateLeft(int[] array, int rotationCount) {
        if (rotationCount == array.length) {
            return array;
        }

        int[] rotatedA = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int indexAfterRotation = i - rotationCount;
            if (indexAfterRotation < 0) {
                indexAfterRotation += array.length;
            }
            rotatedA[indexAfterRotation] = array[i];
        }

        return rotatedA;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotateLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
