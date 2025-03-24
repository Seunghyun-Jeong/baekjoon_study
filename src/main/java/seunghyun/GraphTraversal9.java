package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal9 {
    private static int[][] maze;
    private static int[][] distance;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (2 > M || M > 100) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        maze = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            if (line.length() != M) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
                distance[i][j] = -1;
            }
        }

        int result = bfs(0, 0, N, M);
        System.out.println(result);
    }

    private static int bfs(int startX, int startY, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        distance[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && N > nx && M > ny && maze[nx][ny] == 1 && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return distance[N - 1][M - 1];
    }
}