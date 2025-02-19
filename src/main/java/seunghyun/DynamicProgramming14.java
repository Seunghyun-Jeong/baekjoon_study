package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (1 > A || A > 500 || 1 > B || B > 500) {
                throw new IllegalArgumentException();
            }
            wires[i][0] = A;
            wires[i][1] = B;
        }

        Arrays.sort(wires, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[i][1] > wires[j][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            length = Math.max(length, dp[i]);
        }

        System.out.println(N - length);
    }
}