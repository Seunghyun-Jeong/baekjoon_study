package seunghyun;

import java.util.Scanner;

public class DynamicProgramming16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > 100000) {
            throw new IllegalArgumentException();
        }

        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            int W = sc.nextInt();
            if (1 > W || W > 100000) {
                throw new IllegalArgumentException();
            }
            int V = sc.nextInt();
            if (0 > V || V > 1000) {
                throw new IllegalArgumentException();
            }

            weights[i] = W;
            values[i] = V;
        }

        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            for (int w = K; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}