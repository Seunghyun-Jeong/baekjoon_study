package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MST3 {
    private static int[] parent;

    private static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (1 > n || n > 100) {
            throw new IllegalArgumentException();
        }

        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            stars[i][0] = sc.nextDouble();
            if (0 > stars[i][0] || stars[i][0] > 1000) {
                throw new IllegalArgumentException();
            }
            stars[i][1] = sc.nextDouble();
            if (0 > stars[i][1] || stars[i][1] > 1000) {
                throw new IllegalArgumentException();
            }
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double dist = Math.sqrt(dx * dx + dy * dy);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double totalCost = 0.0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.weight;
            }
        }

        System.out.printf("%.2f\n", totalCost);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        parent[rootB] = rootA;
        return true;
    }
}