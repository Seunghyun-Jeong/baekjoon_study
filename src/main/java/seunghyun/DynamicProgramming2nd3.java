package seunghyun;

import java.util.Scanner;

public class DynamicProgramming2nd3 {
    private static int M, N;
    private static int[][] map;
    private static int[][] dp;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        if (1 > M || M > 500) {
            throw new IllegalArgumentException();
        }
        N = sc.nextInt();
        if (1 > N || N > 500) {
            throw new IllegalArgumentException();
        }

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (1 > map[i][j] || map[i][j] > 10000) {
                    throw new IllegalArgumentException();
                }
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && M > nx && ny >= 0 && N > ny && map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}