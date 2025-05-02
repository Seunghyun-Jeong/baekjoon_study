package seunghyun;

import java.util.Scanner;

public class UnionFind4 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (3 > n || n > 500000) {
            throw new IllegalArgumentException();
        }
        int m = sc.nextInt();
        if (3 > m || m > 1000000) {
            throw new IllegalArgumentException();
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (0 > x || x >= n) {
                throw new IllegalArgumentException();
            }
            int y = sc.nextInt();
            if (0 > y || y >= n) {
                throw new IllegalArgumentException();
            }

            if (find(x) == find(y)) {
                System.out.println(i + 1);
                return;
            } else {
                union(x, y);
            }
        }

        System.out.println(0);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (y > x) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}