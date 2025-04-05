package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra6 {
    private static final int INF = 100000 * 100 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 100000) {
            throw new IllegalArgumentException();
        }

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == b) {
                throw new IllegalArgumentException();
            }
            int c = sc.nextInt();
            if (1 > c || c > 100000) {
                throw new IllegalArgumentException();
            }
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((dist[i][j] == INF ? 0 : dist[i][j]) + " ");
            }
            System.out.println();
        }
    }
}