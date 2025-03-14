package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 10000000) {
            throw new IllegalArgumentException();
        }

        int[] memory = new int[N];
        for (int i = 0; i < N; i++) {
            memory[i] = sc.nextInt();
            if (1 > memory[i] || memory[i] > 10000000) {
                throw new IllegalArgumentException();
            }
        }

        int[] cost = new int[N];
        int totalCost = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            if (0 > cost[i] || cost[i] > 100) {
                throw new IllegalArgumentException();
            }
            totalCost += cost[i];
        }

        int[] dp = new int[totalCost + 1];
        for (int i = 0; i < N; i++) {
            for (int j = totalCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                result = Math.min(result, i);
            }
        }

        System.out.println(result);
    }
}