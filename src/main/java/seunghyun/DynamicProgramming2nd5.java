package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > 10000) {
            throw new IllegalArgumentException();
        }

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
            if (1 > coins[i] || coins[i] > 100000) {
                throw new IllegalArgumentException();
            }
        }

        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int amount = coin; amount <= K; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }
        System.out.println(dp[K]);
    }
}