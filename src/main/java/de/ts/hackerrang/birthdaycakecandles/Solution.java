package de.ts.hackerrang.birthdaycakecandles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] candleHeights) {

        int tallestCandleHeight = 0;
        int tallestCandleCount = 0;

        for (int candleHeight : candleHeights) {
            if (candleHeight > tallestCandleHeight) {
                tallestCandleCount = 1;
                tallestCandleHeight = candleHeight;
            } else if (candleHeight == tallestCandleHeight) {
                tallestCandleCount++;
            }
        }
        return tallestCandleCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
