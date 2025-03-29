package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 15) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 15) {
            throw new IllegalArgumentException();
        }

        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > y) {
                throw new IllegalArgumentException();
            }
            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u < v) {
                throw new IllegalArgumentException();
            }
            board[u] = v;
        }

        int result = bfs(board);
        System.out.println(result);
    }

    private static int bfs(int[] board) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int rolls = current[1];

            if (position == 100) {
                return rolls;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = position + dice;
                if (nextPos > 100) {
                    continue;
                }
                nextPos = board[nextPos];

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, rolls + 1});
                }
            }
        }
        return -1;
    }
}