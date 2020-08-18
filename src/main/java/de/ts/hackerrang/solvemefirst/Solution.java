package de.ts.hackerrang.solvemefirst;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/solve-me-first
 * <p>
 * Complexity: O(1)
 */
class Solution {


    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}

