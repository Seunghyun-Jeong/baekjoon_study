package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal10 {
    private static int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (0 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (0 > K || K > 100000) {
            throw new IllegalArgumentException();
        }
        int result = bfs(N, K);
        System.out.println(result);
    }

    private static int bfs(int start, int target) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while ((!queue.isEmpty())) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == target) {
                return time;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && MAX >= next && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
        return -1;
    }
}