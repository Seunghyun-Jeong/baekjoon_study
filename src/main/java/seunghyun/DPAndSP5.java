package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class DPAndSP5 {
    private static int[][] dp;
    private static int[][] position;
    private static int N, W;
    private static int[][] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (5 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        W = sc.nextInt();
        if (1 > W || W > 1000) {
            throw new IllegalArgumentException();
        }

        position = new int[W + 1][2];
        dp = new int[W + 1][W + 1];
        path = new int[W + 1][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 1; i <= W; i++) {
            position[i][0] = sc.nextInt();
            position[i][1] = sc.nextInt();
        }

        System.out.println(policeSolution(0, 0));
        printTrace();
    }

    private static int policeSolution(int first, int second) {
        int event = Math.max(first, second) + 1;
        if (event > W) {
            return 0;
        }

        if (dp[first][second] != -1) {
            return dp[first][second];
        }

        int move1 = policeSolution(event, second) + distance(first, event, 1);
        int move2 = policeSolution(first, event) + distance(second, event, 2);

        if (move1 < move2) {
            dp[first][second] = move1;
            path[first][second] = 1;
        } else {
            dp[first][second] = move2;
            path[first][second] = 2;
        }

        return dp[first][second];
    }

    private static int distance(int from, int to, int carType) {
        int x1, y1;
        if (from == 0) {
            if (carType == 1) {
                x1 = 1;
                y1 = 1;
            } else {
                x1 = N;
                y1 = N;
            }
        } else {
            x1 = position[from][0];
            y1 = position[from][1];
        }

        int x2 = position[to][0];
        int y2 = position[to][1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void printTrace() {
        int first = 0, second = 0;

        for (int i = 1; i <= W; i++) {
            int selected = path[first][second];
            System.out.println(selected);
            if (selected == 1) {
                first = Math.max(first, second) + 1;
            } else {
                second = Math.max(first, second) + 1;
            }
        }
    }
}