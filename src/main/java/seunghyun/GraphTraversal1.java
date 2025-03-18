package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GraphTraversal1 {
    private static int[] visitOrder;
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (5 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 200000) {
            throw new IllegalArgumentException();
        }
        int R = sc.nextInt();
        if (1 > R || R > N) {
            throw new IllegalArgumentException();
        }

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];
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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        visitOrder[node] = order++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}