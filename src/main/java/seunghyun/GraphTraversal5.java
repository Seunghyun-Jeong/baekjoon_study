package seunghyun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (0 > M || M > (N * (N - 1)) / 2) {
            throw new IllegalArgumentException();
        }
        
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (1 > u || u > N || 1 > v || v > N || u == v) {
                throw new IllegalArgumentException();
            }
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.println(bfs(graph, N));
    }

    private static int bfs(List<Integer>[] graph, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }
}