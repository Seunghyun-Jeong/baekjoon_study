package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class Stack2nd4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
            if (0 > heights[i] || heights[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        long maxArea = getArea(heights);
        System.out.println(maxArea);
    }

    private static long getArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int N = heights.length;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? N : N - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) height * width);
        }

        return maxArea;
    }
}