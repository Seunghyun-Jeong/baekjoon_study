package seunghyun;

import java.util.Scanner;

public class DynamicProgramming12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (1 > A[i] || A[i] > 1000) {
                throw new IllegalArgumentException();
            }
        }

        int[] dp = new int[N];
        int maxLength = 1;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        System.out.println(maxLength);
    }
}