package de.ts.hackerrang.sockmerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Boolean> singleSockExistsForColor = new HashMap<>(n);
        AtomicInteger pairCount = new AtomicInteger();
        for (int colorCode : ar) {
            singleSockExistsForColor.compute(colorCode, (c, sockExists) -> {
                if (sockExists == null) {
                    return true;
                }
                if (sockExists) {
                    pairCount.getAndIncrement();
                    return false;
                }
                return true;
            });
        }

        return pairCount.get();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
