package seunghyun;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Dijkstra3 {
    private static final int INF = Integer.MAX_VALUE;
    private static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (0 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (0 > K || K > 100000) {
            throw new IllegalArgumentException();
        }
        int result = bfs(N, K);
        System.out.println(result);
    }

    private static int bfs(int start, int target) {
        int[] distance = new int[MAX + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[]{start, 0});
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int position = current[0];
            int time = current[1];

            if (position == target) {
                return time;
            }

            int teleport = position * 2;
            if (MAX >= teleport && distance[teleport] > time) {
                distance[teleport] = time;
                deque.addFirst(new int[]{teleport, time});
            }
            for (int next : new int[]{position - 1, position + 1}) {
                if (next >= 0 && MAX >= next && distance[next] > time + 1) {
                    distance[next] = time + 1;
                    deque.addLast(new int[]{next, time + 1});
                }
            }
        }
        return -1;
    }
}