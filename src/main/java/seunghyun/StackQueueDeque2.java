package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class StackQueueDeque2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        if (1 > K || K > 100000) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}
