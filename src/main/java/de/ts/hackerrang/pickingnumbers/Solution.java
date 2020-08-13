package de.ts.hackerrang.pickingnumbers;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/picking-numbers
 * <p>
 * Complexity: O(n)
 */
class Result {

    public static int pickingNumbers(List<Integer> a) {

        AtomicInteger maxNumber = new AtomicInteger(Integer.MIN_VALUE);

        Map<Integer, Integer> numberCount = new HashMap<>();
        a.forEach(n -> {
            numberCount.compute(n, (key, value) -> value == null ? 1 : value + 1);
            maxNumber.set(Math.max(maxNumber.get(), n));
        });

        int maxLength = 0;
        for (int i = 0; i < maxNumber.get(); i++) {
            maxLength = Math.max(maxLength, numberCount.getOrDefault(i, 0) + numberCount.getOrDefault(i + 1, 0));
        }

        return maxLength;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
