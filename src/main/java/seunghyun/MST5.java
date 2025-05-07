package seunghyun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MST5 {
    private static int[] parent;

    private static class Edge {
        int x, y, cost;

        Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            if (1 > m || m > 200000 || m - 1 > n || n > 200000) {
                throw new IllegalArgumentException();
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int totalCost = 0;
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (0 > x || x > m) {
                    throw new IllegalArgumentException();
                }
                int y = sc.nextInt();
                if (0 > y || y > m || x == y) {
                    throw new IllegalArgumentException();
                }
                int z = sc.nextInt();
                edges.add(new Edge(x, y, z));
                totalCost += z;
            }

            edges.sort(Comparator.comparingInt(e -> e.cost));

            int mstCost = 0;
            for (Edge edge : edges) {
                if (find(edge.x) != find(edge.y)) {
                    union(edge.x, edge.y);
                    mstCost += edge.cost;
                }
            }

            System.out.println(totalCost - mstCost);
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}