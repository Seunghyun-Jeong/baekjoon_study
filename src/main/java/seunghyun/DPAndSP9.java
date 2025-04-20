package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DPAndSP9 {
    private static int n, m;
    private static int[][] dist, next;
    private static final int INF = 100000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (1 > n || n > 100) {
            throw new IllegalArgumentException();
        }
        m = sc.nextInt();
        if (1 > m || m > 100000) {
            throw new IllegalArgumentException();
        }
        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            if (dist[u][v] > cost) {
                dist[u][v] = cost;
                next[u][v] = v;
            }
        }

        floydWarshall();
        printDistances();
        printPaths();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];                        next[i][j] = next[i][k];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    private static void printDistances() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((dist[i][j] == INF ? 0 : dist[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static void printPaths() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || next[i][j] == 0) {
                    System.out.println(0);
                } else {
                    List<Integer> path = new ArrayList<>();
                    int u = i;
                    while (u != j) {
                        path.add(u);
                        u = next[u][j];
                    }
                    path.add(j);

                    System.out.print(path.size() + " ");
                    for (int city : path) {
                        System.out.print(city + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}