package seunghyun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[] parent = new int[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
                parent[next] = cur;
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}