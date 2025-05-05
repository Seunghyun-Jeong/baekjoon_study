package seunghyun;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MST4 {
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
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 1000) {
            throw new IllegalArgumentException();
        }

        double[][] stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            stars[i][0] = sc.nextDouble();
            stars[i][1] = sc.nextDouble();
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            union(a, b);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double dist = Math.sqrt(dx * dx + dy * dy);
                pq.add(new Edge(i, j, dist));
            }
        }

        double result = 0.0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.from, e.to)) {
                result += e.weight;
            }
        }

        System.out.printf("%.2f\n", result);
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return false;
        parent[rootB] = rootA;
        return true;
    }
}