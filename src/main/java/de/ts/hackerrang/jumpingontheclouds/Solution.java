package de.ts.hackerrang.jumpingontheclouds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int jumpingOnClouds(int[] clouds) {

        int jumpCount = 0;
        int targetCloud = clouds.length - 1;

        for (int cloudIndex = 0; cloudIndex < targetCloud; ) {
            if (cloudIndex + 2 < clouds.length && clouds[cloudIndex + 2] == 0) {
                cloudIndex += 2;
            } else if (clouds[cloudIndex + 1] == 0) {
                cloudIndex++;
            } else {
                throw new IllegalArgumentException("No possible jump from cloud at index " + cloudIndex);
            }
            jumpCount++;
        }

        return jumpCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
