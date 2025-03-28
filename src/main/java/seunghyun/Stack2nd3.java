package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class Stack2nd3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }

        int[] A = new int[N];
        int[] F = new int[1000001];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (1 > A[i] || A[i] > 1000000) {
                throw new IllegalArgumentException();
            }
            F[A[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && F[A[stack.peek()]] < F[A[i]]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}