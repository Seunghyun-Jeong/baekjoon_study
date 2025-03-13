package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd4 {
    private static int M, N;
    private static int[] weights;
    private static int[] marbles;
    private static boolean[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (1 > N || N > 30) {
            throw new IllegalArgumentException();
        }

        weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            if (1 > weights[i] || weights[i] > 500) {
                throw new IllegalArgumentException();
            }
        }

        M = sc.nextInt();
        if (1 > M || M > 7) {
            throw new IllegalArgumentException();
        }

        marbles = new int[M];
        for (int i = 0; i < M; i++) {
            marbles[i] = sc.nextInt();
            if (1 > marbles[i] || marbles[i] > 40000) {
                throw new IllegalArgumentException();
            }
        }

        dp = new boolean[N + 1][40001];
        dfs(0, 0);

        for (int marble : marbles) {
            if (marble <= 40000 && dp[N][marble]) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }

    private static void dfs(int idx, int weight) {
        if (idx > N || dp[idx][weight]) {
            return;
        }

        dp[idx][weight] = true;

        if (idx < N) {
            dfs(idx + 1, weight + weights[idx]);
            dfs(idx + 1, Math.abs(weight - weights[idx]));
            dfs(idx + 1, weight);
        }
    }
}