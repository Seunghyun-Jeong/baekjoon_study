package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra2 {
    private static final int INF = Integer.MAX_VALUE;
    private static int N, E;
    private static List<List<int[]>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (2 > N || N > 800) {
            throw new IllegalArgumentException();
        }
        E = sc.nextInt();
        if (0 > E || E > 200000) {
            throw new IllegalArgumentException();
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (1 > c || c > 1000) {
                throw new IllegalArgumentException();
            }
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int[] distFromStart = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        long path1 = (long) distFromStart[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFromStart[v2] + distFromV2[v1] + distFromV1[N];
        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[N + 1];
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