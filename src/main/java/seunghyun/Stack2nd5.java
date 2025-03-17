package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class Stack2nd5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500000) {
            throw new IllegalArgumentException();
        }

        long[] heights = new long[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
            if (1 > heights[i] || heights[i] >= (1L << 31)) {
                throw new IllegalArgumentException();
            }
        }

        long visiblePairs = 0;
        Stack<long[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            long currentHeight = heights[i];
            long sameHeightCount = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= currentHeight) {
                long[] top = stack.pop();
                visiblePairs += top[1];
                if (top[0] == currentHeight) {
                    sameHeightCount += top[1];
                }
            }

            if (!stack.isEmpty()) {
                visiblePairs++;
            }

            stack.push(new long[]{currentHeight, sameHeightCount});
        }
        System.out.println(visiblePairs);
    }
}