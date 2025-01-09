package seunghyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueueDeque8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (!(1 <= K && K <= N && N <= 1000)) {
            throw new IllegalArgumentException();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        System.out.print("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            System.out.print(queue.poll());
            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
