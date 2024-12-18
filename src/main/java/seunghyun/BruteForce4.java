package seunghyun;

import java.util.Scanner;

public class BruteForce4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (8 > N || N > 50 || 8 > M || M > 50) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8 ; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint1 = 0;
                int repaint2 = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (board[i + x][j + y] != 'W') {
                                repaint1++;
                            }
                            if (board[i + x][j + y] != 'B') {
                                repaint2++;
                            }
                        } else {
                            if (board[i + x][j + y] != 'B') {
                                repaint1++;
                            }
                            if (board[i + x][j + y] != 'W') {
                                repaint2++;
                            }
                        }
                    }
                }
                int minRepaint = Math.min(repaint1, repaint2);
                count = Math.min(count, minRepaint);
            }
        }
        System.out.println(count);
    }
}
