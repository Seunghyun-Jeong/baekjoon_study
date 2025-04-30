package seunghyun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnionFind3 {
    private static int[] parent;
    private static int[] level;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int F = sc.nextInt();
            if (1 > F || F > 100000) {
                throw new IllegalArgumentException();
            }

            parent = new int[F * 2];
            level = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                String first = sc.next();
                if (!first.matches("^[a-zA-Z]{1,20}$")) {
                    throw new IllegalArgumentException();
                }
                String second = sc.next();
                if (!second.matches("^[a-zA-Z]{1,20}$")) {
                    throw new IllegalArgumentException();
                }

                if (!map.containsKey(first)) {
                    map.put(first, idx++);
                }

                if (!map.containsKey(second)) {
                    map.put(second, idx++);
                }

                System.out.println(union(map.get(first), map.get(second)));
            }
        }
    }

    private static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }

        return level[x];
    }
}