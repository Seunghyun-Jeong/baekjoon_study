package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MST2 {
    private static class Edge implements Comparable<Edge> {
        int from, to, weight;

        private Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int[] parent;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            edgeList.add(new Edge(A, B, C));
        }

        Collections.sort(edgeList);

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        long totalWeight = 0;
        int count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                count++;
                if (count == V - 1)
                    break;
            }
        }

        System.out.println(totalWeight);
    }
}