package de.ts.hackerrang.staircase;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    // Complete the staircase function below.
    static void staircase(int maxStairLevel) {


        for (int stairLevel = 0; stairLevel < maxStairLevel; stairLevel++) {
            for (int j = 0; j < maxStairLevel - stairLevel - 1; j++) {
                System.out.print(" ");
            }

            for (int stairsAtLevel = 0; stairsAtLevel <= stairLevel; stairsAtLevel++) {
                System.out.print("#");
            }

            boolean isLastLevel = stairLevel == maxStairLevel - 1;
            if (!isLastLevel) {
                System.out.println();
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
