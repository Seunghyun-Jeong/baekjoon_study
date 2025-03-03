package seunghyun;

import java.util.Scanner;

public class DivideAndConquer7 {
    private static final int MOD = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 5) {
            throw new IllegalArgumentException();
        }
        long B = sc.nextLong();
        if (1 > B || B > 100000000000L) {
            throw new IllegalArgumentException();
        }

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
                if (0 > A[i][j] || A[i][j] > 1000) {
                    throw new IllegalArgumentException();
                }
            }
        }

        int[][] result = matrixPower(A, B, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixPower(int[][] matrix, long exp, int size) {
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 != 0) {
                result = matrixMultiply(result, matrix, size);
            }
            matrix = matrixMultiply(matrix, matrix, size);
            exp /= 2;
        }

        return result;
    }

    private static int[][] matrixMultiply(int[][] A, int[][] B, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}