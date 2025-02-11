package seunghyun;

import java.util.Scanner;

public class DynamicProgramming6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int[][] costs = new int[N][3];

        for (int i = 0; i < N; i++) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
            costs[i][2] = sc.nextInt();
        }

        int[][] dp = new int[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(result);
    }
}