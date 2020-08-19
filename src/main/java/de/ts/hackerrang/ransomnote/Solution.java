package de.ts.hackerrang.ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> magazineWordCount = new HashMap<>();
        for (String s : magazine) {
            magazineWordCount.compute(s, (key, value) -> value == null ? 1 : value + 1);
        }

        for (String s : note) {
            if (!magazineWordCount.containsKey(s)) {
                System.out.print("No");
                return;
            }

            Integer wordCount = magazineWordCount.get(s);
            if (wordCount == 1) {
                magazineWordCount.remove(s);
            } else {
                magazineWordCount.put(s, wordCount - 1);
            }

        }
        System.out.print("Yes");

    }

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (m >= 0) System.arraycopy(magazineItems, 0, magazine, 0, m);

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (n >= 0) System.arraycopy(noteItems, 0, note, 0, n);

        checkMagazine(magazine, note);

        scanner.close();
    }
}
