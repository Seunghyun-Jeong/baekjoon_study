package seunghyun;

import java.util.Scanner;

public class Backtracking5 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N >= 15) {
            throw new IllegalArgumentException();
        }
        int[] board = new int[N];
        queen(board, 0 ,N);
        System.out.println(count);
    }

    public static void queen(int[] board, int row, int N) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                queen(board, row + 1, N);
                board[row] = 0;
            }
        }
    }

    public static boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}