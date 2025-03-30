package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal15 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 1000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(N, M, map);
        System.out.println(result);
    }

    private static int bfs(int N, int M, int[][] map) {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1, 1});
        visited[0][0][1] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int canBreakWall = current[3];

            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && N > nx && M > ny) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][canBreakWall]) {
                        visited[nx][ny][canBreakWall] = true;
                        queue.add(new int[]{nx, ny, distance + 1, canBreakWall});
                    } else if (map[nx][ny] == 1 && canBreakWall == 1 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.add(new int[]{nx, ny, distance + 1, 0});
                    }
                }
            }
        }
        return -1;
    }
}