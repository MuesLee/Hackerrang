package de.ts.hackerrang.climbingtheleaderboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * <p>
 * Complexity: O(n)
 */
class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] climbingLeaderboard(int[] leaderboardScores, int[] aliceScores) {

        int[] aliceRankings = new int[aliceScores.length];

        int lastScore = Integer.MIN_VALUE;
        int currentRank = 0;

        int aliceScoreIndex = aliceScores.length - 1;

        for (int leaderBoardIndex = 0; leaderBoardIndex < leaderboardScores.length && aliceScoreIndex >= 0; leaderBoardIndex++) {
            int score = leaderboardScores[leaderBoardIndex];
            if (lastScore != score) {
                currentRank++;
                lastScore = score;
            }
            while (aliceScoreIndex >= 0 && score <= aliceScores[aliceScoreIndex]) {
                aliceRankings[aliceScoreIndex] = currentRank;
                aliceScoreIndex--;
            }
        }

        while (aliceScoreIndex >= 0) {
            aliceRankings[aliceScoreIndex--] = currentRank + 1;
        }

        return aliceRankings;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
