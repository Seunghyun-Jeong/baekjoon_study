package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal13 {
    private static int[][][] box;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if (2 > M || M > 100) {
            throw new IllegalArgumentException();
        }
        int N = sc.nextInt();
        if (2 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int H = sc.nextInt();
        if (1 > H || H > 100) {
            throw new IllegalArgumentException();
        }
        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    } else if (box[h][n][m] == 0) {
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs(queue, count, H, N, M);
        System.out.println(result);
    }

    private static int bfs(Queue<int[]> queue, int count, int H, int N, int M) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean ripened = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int z = current[0];
                int x = current[1];
                int y = current[2];

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nz >= 0 && nx >= 0 && ny >= 0 && H > nz && N > nx && M > ny && box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1;
                        queue.add(new int[]{nz, nx, ny});
                        count--;
                        ripened = true;
                    }
                }
            }
            if (ripened == true) {
                days++;
            }
        }
        return count == 0 ? days : -1;
    }
}