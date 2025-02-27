package seunghyun;

import java.util.Scanner;

public class DivideAndConquer3 {
    private static int minusCount = 0;
    private static int zeroCount = 0;
    private static int oneCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 2187 || (N % 3) != 0) {
            throw new IllegalArgumentException();
        }

        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
                if (paper[i][j] != -1 && paper[i][j] != 0 && paper[i][j] != 1) {
                    throw new IllegalArgumentException();
                }
            }
        }

        countPaper(paper, 0, 0, N);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private static void countPaper(int[][] paper, int row, int col, int size) {
        if (isSame(paper, row, col, size)) {
            if (paper[row][col] == -1) {
                minusCount++;
            } else if (paper[row][col] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(paper, row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    private static boolean isSame(int[][] paper, int row, int col, int size) {
        int value = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}