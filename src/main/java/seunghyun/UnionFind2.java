package seunghyun;

import java.util.Scanner;

public class UnionFind2 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 200) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 1000) {
            throw new IllegalArgumentException();
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            if (0 > parent[i]) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int connected = sc.nextInt();
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = sc.nextInt();
        }

        int root = find(plan[0]);
        boolean possible = true;
        for (int i = 1; i < M; i++) {
            if (find(plan[i]) != root) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}