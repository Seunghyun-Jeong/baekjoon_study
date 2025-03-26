package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal11 {
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int l = sc.nextInt();
            if (4 > l || l > 300) {
                throw new IllegalArgumentException();
            }

            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int targetX = sc.nextInt();
            int targetY = sc.nextInt();

            int result = bfs(l, startX, startY, targetX, targetY);
            System.out.println(result);
        }
    }

    private static int bfs(int l, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        boolean[][] visited = new boolean[l][l];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && l > nx && l > ny && !visited[nx][ny]) {
                    if (nx == targetX && ny == targetY) {
                        return moves + 1;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }
        return -1;
    }
}