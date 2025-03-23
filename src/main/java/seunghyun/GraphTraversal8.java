package seunghyun;

import java.util.Scanner;

public class GraphTraversal8 {
    private static int[][] field;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (1 > T || T > 50) {
            throw new IllegalArgumentException();
        }

        for (int t = 0; t < T; t++) {
            int M = sc.nextInt();
            if (1 > M || M > 50) {
                throw new IllegalArgumentException();
            }
            int N = sc.nextInt();
            if (1 > N || N > 50) {
                throw new IllegalArgumentException();
            }
            int K = sc.nextInt();
            if (1 > K || K > 2500) {
                throw new IllegalArgumentException();
            }

            field = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                if (0 > x || x >= M) {
                    throw new IllegalArgumentException();
                }
                int y = sc.nextInt();
                if (0 > y || y >= N) {
                    throw new IllegalArgumentException();
                }
                if (field[x][y] == 1) {
                    throw new IllegalArgumentException();
                }
                field[x][y] = 1;
            }

            int wormCount = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, M, N);
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount);
        }
    }

    private static void dfs(int x, int y, int M, int N) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && M > nx && N > ny && field[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, M, N);
            }
        }
    }
}