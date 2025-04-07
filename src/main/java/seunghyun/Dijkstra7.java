package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra7 {
    private static final int INF = 100000 * 100 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        if (2 > V || V > 400) {
            throw new IllegalArgumentException();
        }
        int E = sc.nextInt();
        if (0 > E || E > V * (V - 1)) {
            throw new IllegalArgumentException();
        }

        int[][] dist = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (1 > c || c > 10000) {
                throw new IllegalArgumentException();
            }
            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int cycle = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    cycle = Math.min(cycle, dist[i][j] + dist[j][i]);
                }
            }
        }

        System.out.println(cycle == INF ? -1 : cycle);
    }
}