package seunghyun;

import java.util.Scanner;

public class DynamicProgramming11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10000) {
            throw new IllegalArgumentException();
        }
        int[] wine = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = sc.nextInt();
            if (0 > wine[i] || wine[i] > 1000) {
                throw new IllegalArgumentException();
            }
        }

        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}