package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DPAndSP6 {
    private static int N, K;
    private static int[] prev = new int[100001];
    private static int[] time = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (0 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        K = sc.nextInt();
        if (0 > K || K > 100000) {
            throw new IllegalArgumentException();
        }

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;
        while (index != N) {
            stack.push(prev[index]);
            index = prev[index];
        }

        System.out.println(time[K] - 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (0 > next || next > 100000) {
                    continue;
                }

                if (time[next] == 0) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                    prev[next] = now;
                }
            }
        }
    }
}