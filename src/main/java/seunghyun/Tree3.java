package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tree3 {
    private static ArrayList<int[]>[] graph;
    private static boolean[] visited;
    private static int max = 0;
    private static int farthestNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (1 > n || n > 10000) {
            throw new IllegalArgumentException();
        }

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int cost = sc.nextInt();
            if (1 > cost || cost > 100) {
                throw new IllegalArgumentException();
            }
            graph[node1].add(new int[]{node2, cost});
            graph[node2].add(new int[]{node1, cost});
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        Arrays.fill(visited, false);
        max = 0;
        dfs(farthestNode, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int distance) {
        if (distance > max) {
            max = distance;
            farthestNode = node;
        }
        visited[node] = true;

        for (int[] next : graph[node]) {
            if (!visited[next[0]]) {
                dfs(next[0], distance + next[1]);
            }
        }
    }
}