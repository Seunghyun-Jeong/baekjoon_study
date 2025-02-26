package seunghyun;

import java.util.Scanner;

public class DivideAndConquer1 {
    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N != 2 && N != 4 && N != 8 && N != 16 && N != 32 && N != 64 && N != 128) {
            throw new IllegalArgumentException();
        }

        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
                if (paper[i][j] != 0 && paper[i][j] != 1) {
                    throw new IllegalArgumentException();
                }
            }
        }

        countColorPaper(paper, 0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void countColorPaper(int[][] paper, int row, int col, int size) {
        if (isSameColor(paper, row, col, size)) {
            if (paper[row][col] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newSize = size / 2;
        countColorPaper(paper, row, col, newSize);
        countColorPaper(paper, row, col + newSize, newSize);
        countColorPaper(paper, row + newSize, col, newSize);
        countColorPaper(paper, row + newSize, col + newSize, newSize);
    }

    private static boolean isSameColor(int[][] paper, int row, int col, int size) {
        int color = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}