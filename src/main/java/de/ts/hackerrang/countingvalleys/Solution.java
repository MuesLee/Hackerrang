package de.ts.hackerrang.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int countingValleys(int totalStepCount, String steps) {

        int valleyCount = 0;
        int currentElevationLevel = 0;
        boolean currentlyInValley = false;

        for (char step : steps.toCharArray()) {
            if (step == 'U') {
                currentElevationLevel++;
            } else if (step == 'D') {
                currentElevationLevel--;
            } else {
                throw new IllegalArgumentException("Expected U or D but was: " + step);
            }

            if (!currentlyInValley && currentElevationLevel < 0) {
                currentlyInValley = true;
            }
            if (currentlyInValley & currentElevationLevel >= 0) {
                currentlyInValley = false;
                valleyCount++;
            }
        }

        return valleyCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
