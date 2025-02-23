package seunghyun;

import java.util.Scanner;

public class PrefixSum6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 2000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 2000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > Math.min(N, M)) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int[][] prefixW = new int[N + 1][M + 1];
        int[][] prefixB = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int addW = 0;
                int addB = 0;

                if ((i + j) % 2 == 0) {
                    if (board[i - 1][j - 1] != 'W') {
                        addW++;
                    }
                    if (board[i - 1][j - 1] != 'B') {
                        addB++;
                    }
                } else {
                    if (board[i - 1][j - 1] != 'B') {
                        addW++;
                    }
                    if (board[i - 1][j - 1] != 'W') {
                        addB++;
                    }
                }
                prefixW[i][j] = prefixW[i - 1][j] + prefixW[i][j - 1] - prefixW[i - 1][j - 1] + addW;
                prefixB[i][j] = prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1] + addB;
            }
        }

        int minPaint = Integer.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= M - K; j++) {
                int x2 = i + K;
                int y2 = j + K;

                int countW = prefixW[x2][y2] - prefixW[i][y2] - prefixW[x2][j] + prefixW[i][j];
                int countB = prefixB[x2][y2] - prefixB[i][y2] - prefixB[x2][j] + prefixB[i][j];

                minPaint = Math.min(minPaint, Math.min(countW, countB));
            }
        }

        System.out.println(minPaint);
    }
}