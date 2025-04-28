package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree7 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;

        while (true) {
            int n = sc.nextInt();
            if (0 > n || n > 500) {
                throw new IllegalArgumentException();
            }
            int m = sc.nextInt();
            if (0 > m || m > n*(n-1)/2) {
                throw new IllegalArgumentException();
            }
            
            if (n == 0 && m == 0) {
                break;
            }
            
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            
            visited = new boolean[n + 1];
            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (isTree(i, -1)) {
                        treeCount++;
                    }
                }
            }

            if (treeCount == 0) {
                System.out.println("Case " + caseNumber + ": No trees.");
            } else if (treeCount == 1) {
                System.out.println("Case " + caseNumber + ": There is one tree.");
            } else {
                System.out.println("Case " + caseNumber + ": A forest of " + treeCount + " trees.");
            }
            caseNumber++;
        }
    }

    private static boolean isTree(int node, int parent) {
        visited[node] = true;
        boolean isTree = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (!isTree(neighbor, node)) {
                    isTree = false;
                }
            } else if (neighbor != parent) {
                isTree = false;
            }
        }
        return isTree;
    }
}