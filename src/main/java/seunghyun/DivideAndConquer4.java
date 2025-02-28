package seunghyun;

import java.util.Scanner;

public class DivideAndConquer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (1 > A || 1 > B || 1 > C || A > 2147483647 || B > 2147483647 || C > 2147483647) {
            throw new IllegalArgumentException();
        }

        System.out.println(modularExponentiation(A, B, C));
    }

    private static long modularExponentiation(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }

        long half = modularExponentiation(base, exp / 2, mod);
        long result = (half * half) % mod;

        if (exp % 2 != 0) {
            result = (result * base) % mod;
        }

        return result;
    }
}