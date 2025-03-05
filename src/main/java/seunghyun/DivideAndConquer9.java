package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class DivideAndConquer9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }

            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
                if (0 > heights[i] || heights[i] > 1000000000) {
                    throw new IllegalArgumentException();
                }
            }

            System.out.println(findMaxRectangleArea(heights));
        }
    }

    private static long findMaxRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int index = 0;

        while (heights.length > index) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                long area = (long) heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = (long) heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}