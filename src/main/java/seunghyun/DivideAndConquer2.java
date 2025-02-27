package seunghyun;

import java.util.Scanner;

public class DivideAndConquer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 64 || (N & (N - 1)) != 0) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        int[][] video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = line.charAt(j) - '0';
                if (video[i][j] != 0 && video[i][j] != 1) {
                    throw new IllegalArgumentException();
                }
            }
        }
        compress(video, 0, 0, N);
    }

    private static void compress(int[][] video, int row, int col, int size) {
        if (isSame(video, row, col, size)) {
            System.out.print(video[row][col]);
            return;
        }

        int newSize = size / 2;
        System.out.print("(");
        compress(video, row, col, newSize);
        compress(video, row, col + newSize, newSize);
        compress(video, row + newSize, col, newSize);
        compress(video, row + newSize, col + newSize, newSize);
        System.out.print(")");
    }

    private static boolean isSame(int[][] video, int row, int col, int size) {
        int value = video[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}