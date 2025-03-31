package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GraphTraversal16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        if (2 > K || K > 5) {
            throw new IllegalArgumentException();
        }

        for (int t = 0; t < K; t++) {
            int V = sc.nextInt();
            if (1 > V || V > 20000) {
                throw new IllegalArgumentException();
            }
            int E = sc.nextInt();
            if (1 > E || E > 200000) {
                throw new IllegalArgumentException();
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                if (u == v) {
                    throw new IllegalArgumentException();
                }
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            if (isBipartite(graph, V)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartite(List<List<Integer>> graph, int V) {
        int[] colors = new int[V + 1];
        Arrays.fill(colors, 0);

        for (int i = 1; i <= V; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, i, colors, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(List<List<Integer>> graph, int node, int[] colors, int color) {
        colors[node] = color;

        for (int neighbor : graph.get(node)) {
            if (colors[neighbor] == 0) {
                if (!dfs(graph, neighbor, colors, -color)) {
                    return false;
                }
            } else if (colors[neighbor] == colors[node]) {
                return false;
            }
        }

        return true;
    }
}