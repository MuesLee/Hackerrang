package de.ts.hackerrang.designerpdfviewer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final int ASCII_INDEX_FIRST_LOWERCASE_LETTER = 97;
    private static final Scanner scanner = new Scanner(System.in);

    static int designerPdfViewer(int[] characterHeights, String word) {

        if (word == null || word.isEmpty()) {
            return 0;
        }

        int maxCharacterHeight = word.chars().map(c -> characterHeights[c - ASCII_INDEX_FIRST_LOWERCASE_LETTER]).max().orElseThrow(IllegalArgumentException::new);

        return maxCharacterHeight * word.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
