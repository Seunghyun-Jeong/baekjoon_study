package seunghyun;

import java.util.Scanner;

public class DivideAndConquer5 {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 4000000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (0 > K || K > N) {
            throw new IllegalArgumentException();
        }

        System.out.println(binomialCoefficient(N, K));
    }

    private static long binomialCoefficient(int N, int K) {
        if (K == 0 || N == K) {
            return 1;
        }

        long[] factorial = new long[N + 1];
        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        long numerator = factorial[N];
        long denominator = factorial[K] * factorial[N - K] % MOD;

        return numerator * modInverse(denominator, MOD) % MOD;
    }

    private static long modInverse(long A, int MOD) {
        return power(A, MOD - 2, MOD);
    }

    private static long power(long base, long exp, int MOD) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2, MOD);
        long result = (half * half) % MOD;

        if (exp % 2 != 0) {
            result = (result * base) % MOD;
        }

        return result;
    }
}