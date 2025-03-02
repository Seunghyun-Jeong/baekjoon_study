package seunghyun;

import java.util.Scanner;

public class DivideAndConquer6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 100) {
            throw new IllegalArgumentException();
        }

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
                if (Math.abs(A[i][j]) > 100) {
                    throw new IllegalArgumentException();
                }
            }
        }

        int M2 = sc.nextInt();
        if (M2 != M) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > 100) {
            throw new IllegalArgumentException();
        }

        int[][] B = new int[M2][K];
        for (int i = 0; i < M2; i++) {
            for (int j = 0; j < K; j++) {
                B[i][j] = sc.nextInt();
                if (Math.abs(B[i][j]) > 100) {
                    throw new IllegalArgumentException();
                }
            }
        }

        int[][] C = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}