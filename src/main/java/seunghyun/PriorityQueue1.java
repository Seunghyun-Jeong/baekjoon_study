package seunghyun;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();

            if (X > 0) {
                if (X > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException();
                }
                maxHeap.add(X);
            } else if (X == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(maxHeap.poll());
                }
            }
        }
    }
}