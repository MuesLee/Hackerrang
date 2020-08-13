package de.ts.hackerrang.timeconversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Scanner;

/**
 * Complexity: O(1)
 * <p>
 * https://www.hackerrank.com/challenges/time-conversion
 */
public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String given12HourFormatTime) {

        TemporalAccessor time = new DateTimeFormatterBuilder().appendPattern("hh:mm:ssa")
                .toFormatter(Locale.US).parse(given12HourFormatTime);
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
