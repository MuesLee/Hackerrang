package de.ts.hackerrang.dayoftheprogrammer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    static String dayOfProgrammer(int year) {
        if (year == 1918) {
            return "26.09.1918";
        } else if (year < 1919) {
            if (year % 4 != 0)
                return "13.09." + year;

            else return "12.09." + year;
        } else {
            LocalDate startOfGivenYear = LocalDate.of(year, 1, 1);
            LocalDate dayOfTheProgrammer = startOfGivenYear.plusDays(255);
            return dateTimeFormatter.format(dayOfTheProgrammer);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
