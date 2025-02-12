package seunghyun;

import java.util.Scanner;

public class DynamicProgramming7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500) {
            throw new IllegalArgumentException();
        }
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = triangle[N - 1][i];
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}