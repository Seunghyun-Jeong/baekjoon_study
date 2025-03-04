package seunghyun;

import java.util.Scanner;

public class DivideAndConquer8 {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if (1 > N || N > 1000000000000000000L) {
            throw new IllegalArgumentException();
        }

        long[][] result = fibonacciMatrixPower(N - 1);
        System.out.println(result[0][0]);
    }

    private static long[][] fibonacciMatrixPower(long exp) {
        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = {{1, 0}, {0, 1}};

        while (exp > 0) {
            if (exp % 2 != 0) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            exp /= 2;
        }

        return result;
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return result;
    }
}