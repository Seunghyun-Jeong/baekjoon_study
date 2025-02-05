package seunghyun;

import java.util.Scanner;

public class Backtracking8 {
    private static int N;
    private static int[][] S;
    private static boolean[] visited;
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (!(4 <= N && N <= 20) || N % 2 != 0) {
            throw new IllegalArgumentException();
        }
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        backtracking(0, 0);
        System.out.println(minDiff);
    }

    public static void backtracking(int idx, int count) {
        if (count == N /2) {
            calculateDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculateDiff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += S[i][j];
                }
                if (!visited[i] && !visited[j]) {
                    teamLink += S[i][j];
                }
            }
        }

        int diff = Math.abs(teamStart - teamLink);
        if (diff < minDiff) {
            minDiff = diff;
        }
    }
}