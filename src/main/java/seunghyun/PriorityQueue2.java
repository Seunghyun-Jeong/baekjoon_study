package seunghyun;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            if (0 > X || X >= Math.pow(2, 31)) {
                throw new IllegalArgumentException();
            }

            if (X > 0) {
                minHeap.add(X);
            } else if (X == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            }
        }
    }
}