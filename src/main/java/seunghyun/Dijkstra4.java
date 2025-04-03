package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra4 {
    private static final int INF = Integer.MAX_VALUE;
    private static int n, m, t, s, g, h;
    private static List<List<int[]>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (1 > T || T > 100) {
            throw new IllegalArgumentException();
        }
        while (T-- > 0) {
            n = sc.nextInt();
            if (2 > n || n > 2000) {
                throw new IllegalArgumentException();
            }
            m = sc.nextInt();
            t = sc.nextInt();
            if ((1 > m || m > 50000) && (1 > t || t > 100)) {
                throw new IllegalArgumentException();
            }

            s = sc.nextInt();
            g = sc.nextInt();
            h = sc.nextInt();
            if (1 > s || s > n || 1 > g || g > n || 1 > h || h > n || g == h) {
                throw new IllegalArgumentException();
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            int ghDistance = 0;
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                if ((1 > a || 1 > b || n > a || n > b) && (1 > d || d > 1000)) {
                    throw new IllegalArgumentException();
                }
                graph.get(a).add(new int[]{b, d});
                graph.get(b).add(new int[]{a, d});
                if ((a == g && b == h) || (a == h && b == g)) {
                    ghDistance = d;
                }
            }

            List<Integer> destations = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                destations.add(sc.nextInt());
            }

            int[] distFromS = dijkstra(s);
            int[] distFromG = dijkstra(g);
            int[] distFromH = dijkstra(h);

            List<Integer> results = new ArrayList<>();
            for (int x : destations) {
                int path1 = distFromS[g] + ghDistance + distFromH[x];
                int path2 = distFromS[h] + ghDistance + distFromG[x];

                if (distFromS[x] == path1 || distFromS[x] == path2) {
                    results.add(x);
                }
            }

            Collections.sort(results);
            for (int res : results) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
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