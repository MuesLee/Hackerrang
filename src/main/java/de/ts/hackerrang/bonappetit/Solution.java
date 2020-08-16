package de.ts.hackerrang.bonappetit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 * <p>
 * Complexity: O(n)
 */
public class Solution {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int indexOfSkippedMeal, int calculatedShare) {
        int costOfAllMeals = bill.stream().reduce(0, (sum, i) -> sum += i);
        int costOfSharedMeals = costOfAllMeals - bill.get(indexOfSkippedMeal);
        int equalShare = costOfSharedMeals / 2;

        String result = equalShare == calculatedShare ? "Bon Appetit" : Integer.toString(calculatedShare - equalShare);
        System.out.print(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
