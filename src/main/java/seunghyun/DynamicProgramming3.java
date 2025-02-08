package seunghyun;

import java.util.Scanner;

public class DynamicProgramming3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (N == 2) {
            System.out.println(2);
            return;
        }

        int mod = 15746;
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        System.out.println(dp[N]);
    }
}