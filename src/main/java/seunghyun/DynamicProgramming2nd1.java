package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            if (3 > K || K > 500) {
                throw new IllegalArgumentException();
            }

            int[] files = new int[K + 1];
            int[] prefixSum = new int[K + 1];
            for (int j = 1; j <= K; j++) {
                int size = sc.nextInt();
                if (1 > size || size > 10000) {
                    throw new IllegalArgumentException();
                }
                files[j] = size;
                prefixSum[j] = prefixSum[j - 1] + files[j];
            }

            int[][] dp = new int[K + 1][K + 1];
            for (int gap = 1; gap < K; gap++) {
                for (int j = 1; j + gap <= K; j++) {
                    int k = j + gap;
                    dp[j][k] = Integer.MAX_VALUE;

                    for (int l = j; l < k; l++) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + (prefixSum[k] - prefixSum[j - 1]));
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}