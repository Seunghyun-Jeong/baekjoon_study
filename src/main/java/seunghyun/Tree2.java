package seunghyun;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree2 {
    private static ArrayList<Node>[] list;
    private static boolean[] visited;
    private static int node;
    private static int max = 0;

    private static class Node {
        int E;
        int cost;

        private Node(int E, int cost) {
            this.E = E;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        if (2 > V || V > 100000) {
            throw new IllegalArgumentException();
        }

        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int cost = sc.nextInt();
                if (1 > cost || cost > 10000) {
                    throw new IllegalArgumentException();
                }
                list[S].add(new Node(E, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if (visited[n.E] == false) {
                dfs(n.E, n.cost + len);
                visited[n.E] = true;
            }
        }
    }
}