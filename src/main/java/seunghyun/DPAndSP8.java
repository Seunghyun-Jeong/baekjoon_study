package seunghyun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class DPAndSP8 {
    private static int n, m;
    private static Node[] graph;

    private static class Node{
        int v;
        int h;
        Node link;

        private Node(int v, int h, Node link) {
            this.v = v;
            this.h = h;
            this.link = link;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (1 > n || n > 1000) {
            throw new IllegalArgumentException();
        }
        m = sc.nextInt();
        if (1 > m || m > 100000) {
            throw new IllegalArgumentException();
        }
        graph = new Node[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int h = sc.nextInt();
            graph[u] = new Node(v, h ,graph[u]);
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start, end);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.h));
        pq.offer(new Node(start, 0, graph[start]));
        int[] distance = new int[n + 1];
        int[] route = new int[n + 1];
        Arrays.fill(distance, 100000000);
        Arrays.fill(route, -1);

        distance[start] = 0;
        route[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Node temp = graph[curr.v]; temp != null ; temp = temp.link) {
                if (distance[temp.v] > distance[curr.v] + temp.h) {
                    pq.offer(new Node(temp.v, temp.h, null));
                    distance[temp.v] = distance[curr.v] + temp.h;
                    pq.offer(new Node(temp.v, distance[temp.v], null));
                    route[temp.v] = curr.v;
                }
            }
        }

        System.out.println(distance[end]);

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (end != 0) {
            stack.push(end);
            end = route[end];
            count++;
        }

        System.out.println(count);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}