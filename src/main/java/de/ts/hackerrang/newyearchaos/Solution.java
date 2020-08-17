package de.ts.hackerrang.newyearchaos;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static void minimumBribes(int[] bribedQueue) {

        int minimumNumberOfBribes = 0;

        for (int i = 0; i < bribedQueue.length; i++) {
            int actualQueueNumber = bribedQueue[i];
            int expectedQueueNumber = i + 1;

            int indexDelta = actualQueueNumber - expectedQueueNumber;

            if (indexDelta > 2) {
                System.out.println("Too chaotic");
                return;
            }

            if (indexDelta > 0) {
                for (int j = 1; j <= indexDelta && i + j < bribedQueue.length; j++) {
                    int rightNeighbour = bribedQueue[i + j];
                    if (rightNeighbour < actualQueueNumber) {
                        ++minimumNumberOfBribes;
                    }
                }
            } else {
                for (int j = -1; j > indexDelta && j + i >= 0; j--) {
                    int leftNeighbour = bribedQueue[i + j];
                    if (leftNeighbour > actualQueueNumber) {
                        ++minimumNumberOfBribes;
                    }
                }
            }
        }

        System.out.println(minimumNumberOfBribes);
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
