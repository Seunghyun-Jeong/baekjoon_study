package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal12 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if (2 > M || M > 1000) {
            throw new IllegalArgumentException();
        }
        int N = sc.nextInt();
        if (2 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else if (box[i][j] == 0) {
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }

        int days = bfs(queue, count, N, M, box);
        System.out.println(days);
    }

    private static int bfs(Queue<int[]> queue, int count, int N, int M, int[][] box) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean ripened = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && N > nx && M > ny && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
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