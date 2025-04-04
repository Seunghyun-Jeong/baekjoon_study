package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra5 {
    private static final int INF = Integer.MAX_VALUE;
    private static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (1 > n || n > 500) {
            throw new IllegalArgumentException();
        }
        int m = sc.nextInt();
        if (1 > m || m > 6000) {
            throw new IllegalArgumentException();
        }
        Edge[] graph = new Edge[m];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            if (1 > a || a > n) {
                throw new IllegalArgumentException();
            }
            int b = sc.nextInt();
            if (1 > b || b > n) {
                throw new IllegalArgumentException();
            }
            int c = sc.nextInt();
            if (-10000 > c || c > 10000) {
                throw new IllegalArgumentException();
            }
            graph[i] = new Edge(a, b, c);
        }

        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge now_edge = graph[j];
                if (dist[now_edge.from] != INF && dist[now_edge.to] > dist[now_edge.from] + now_edge.weight) {
                    dist[now_edge.to] = dist[now_edge.from] + now_edge.weight; // update
                }
            }
        }

        boolean cycle = false;
        for (int i = 0; i < m; i++) {
            Edge now_edge = graph[i];
            if (dist[now_edge.from] != INF && dist[now_edge.to] > dist[now_edge.from] + now_edge.weight) {
                cycle = true;
                break;
            }
        }

        if (cycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i] == INF ? "-1" : dist[i]);
            }
        }
    }
}