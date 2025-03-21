package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal6 {
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static List<Integer> dfsResult;
    private static List<Integer> bfsResult;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 10000) {
            throw new IllegalArgumentException();
        }
        int V = sc.nextInt();
        if (1 > V || V > N) {
            throw new IllegalArgumentException();
        }

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dfsResult = new ArrayList<>();
        bfsResult = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (1 > u || u > N || 1 > v || v > N) {
                throw new IllegalArgumentException();
            }
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);

        Arrays.fill(visited, false);
        bfs(V);
        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.print(dfsResult.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.print(bfsResult.get(i) + " ");
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        dfsResult.add(node);

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsResult.add(current);

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}