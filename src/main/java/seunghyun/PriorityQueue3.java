package seunghyun;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) {
                        return Integer.compare(a, b);
                    }
                    return Integer.compare(absA, absB);
                }
        );
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            if (X <= -Math.pow(2, 31) || X >= Math.pow(2, 31)) {
                throw new IllegalArgumentException();
            }

            if (X != 0) {
                absHeap.add(X);
            } else {
                if (absHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absHeap.poll());
                }
            }
        }
    }
}