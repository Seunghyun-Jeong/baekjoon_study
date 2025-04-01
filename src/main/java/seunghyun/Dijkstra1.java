package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra1 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        if (1 > V || V > 20000) {
            throw new IllegalArgumentException();
        }
        int E = sc.nextInt();
        if (1 > E || E > 300000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > V) {
            throw new IllegalArgumentException();
        }

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u == v) {
                throw new IllegalArgumentException();
            }
            int w = sc.nextInt();
            if (1 > w || w > 10) {
                throw new IllegalArgumentException();
            }
            graph.get(u).add(new int[]{v, w});
        }

        int[] distances = dijkstra(graph, V, K);

        for (int i = 1; i <= V; i++) {
            System.out.println(distances[i] == INF ? "INF" : distances[i]);
        }
    }

    private static int[] dijkstra(List<List<int[]>> graph, int V, int start) {
        int[] distances = new int[V + 1];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances[currentNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (distances[nextNode] > currentDistance + weight) {
                    distances[nextNode] = currentDistance + weight;
                    pq.add(new int[]{nextNode, distances[nextNode]});
                }
            }
        }
        return distances;
    }
}