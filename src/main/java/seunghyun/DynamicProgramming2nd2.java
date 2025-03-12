package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500) {
            throw new IllegalArgumentException();
        }

        int[] dimensions = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int R = sc.nextInt();
            if (1 > R || R > 500) {
                throw new IllegalArgumentException();
            }
            int C = sc.nextInt();
            if (1 > C || C > 500) {
                throw new IllegalArgumentException();
            }
            dimensions[i] = R;
            dimensions[i + 1] = C;
        }

        int[][] dp = new int[N][N];
        for (int gap = 1; gap < N; gap++) {
            for (int i = 0; i + gap < N; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}