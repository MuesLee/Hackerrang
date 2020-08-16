package de.ts.hackerrang.repeatedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final int ASCII_INDEX_OF_LOWERCASE_A = 97;
    private static final Scanner scanner = new Scanner(System.in);

    static long repeatedString(String sequence, long relevantCharacterCount) {

        long totalCountOfA = countLowerCaseA(sequence, sequence.length());
        long sequenceMultiplier = relevantCharacterCount / sequence.length();
        totalCountOfA *= sequenceMultiplier;

        long lengthOfLastSequence = relevantCharacterCount % sequence.length();
        if (lengthOfLastSequence != 0) {
            totalCountOfA += countLowerCaseA(sequence, lengthOfLastSequence);
        }

        return totalCountOfA;
    }

    private static long countLowerCaseA(String sequence, long maxIndex) {
        return sequence.chars().limit(maxIndex).filter(charCode -> charCode == ASCII_INDEX_OF_LOWERCASE_A).count();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
