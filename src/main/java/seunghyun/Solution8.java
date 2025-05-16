package seunghyun;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution8 {
    private static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            g[u][v] = g[v][u] = true;
        }

        ArrayList<Edge> ans = new ArrayList<>();
        int R = 0;

        for (int i = 0; i < n; i++) {
            g[i][i] = true;
        }

        if (2 * (n - 1) >= (n * (n - 1)) / 2) {
            R = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!g[i][j]) {
                        ans.add(new Edge(i + 1, j + 1));
                        g[i][j] = g[j][i] = true;
                    }
                }
            }
        } else {
            R = 2;
            for (int i = 0; i < n; i++) {
                if (!g[i][0]) {
                    ans.add(new Edge(i + 1, 1));
                    g[i][0] = g[0][i] = true;
                }
            }
        }

        System.out.println(ans.size());
        System.out.println(R);
        for (Edge e : ans) {
            System.out.println(e.u + " " + e.v);
        }
    }
}