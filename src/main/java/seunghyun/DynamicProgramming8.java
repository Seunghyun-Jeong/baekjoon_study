package seunghyun;

import java.util.Scanner;

public class DynamicProgramming8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 300) {
            throw new IllegalArgumentException();
        }
        int[] scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            scores[i] = sc.nextInt();
            if (1 > scores[i] || scores[i] > 10000) {
                throw new IllegalArgumentException();
            }
        }

        if (N == 1) {
            System.out.println(scores[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        System.out.println(dp[N]);
    }
}