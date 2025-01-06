package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class StackQueueDeque5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int currentNum = 1;
        for (int student : input) {
            while (!stack.isEmpty() && stack.peek() == currentNum) {
                stack.pop();
                currentNum++;
            }
            if (student == currentNum) {
                currentNum++;
            } else {
                stack.push(student);
            }
        }
        while (!stack.isEmpty() && stack.peek() == currentNum) {
            stack.pop();
            currentNum++;
        }
        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
