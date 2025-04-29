package seunghyun;

import java.util.Scanner;

public class UnionFind1 {
    private static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (1 > n || n > 1000000) {
            throw new IllegalArgumentException();
        }
        int m = sc.nextInt();
        if (1 > m || m > 100000) {
            throw new IllegalArgumentException();
        }
        
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}