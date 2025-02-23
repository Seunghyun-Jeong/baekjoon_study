package seunghyun;

import java.util.Scanner;

public class PrefixSum5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 2024) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 100000) {
            throw new IllegalArgumentException();
        }

        int[][] matrix = new int[N + 1][N + 1];
        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = sc.nextInt();
                if (0 > matrix[i][j] || matrix[i][j] > 1000) {
                    throw new IllegalArgumentException();
                }

                prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            if (1 > x1 || x1 > x2 || x2 > N || 1 > y1 || y1 > y2 || y2 > N) {
                throw new IllegalArgumentException();
            }

            int sum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 -1] + prefixSum[x1 - 1][y1 - 1];
            System.out.println(sum);
        }
    }
}