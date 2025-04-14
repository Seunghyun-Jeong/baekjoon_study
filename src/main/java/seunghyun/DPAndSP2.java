package seunghyun;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DPAndSP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (1 > arr[i] || arr[i] > 1000) {
                throw new IllegalArgumentException();
            }
        }

        int[] dp = new int[N];
        int[] prev = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int lastIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    lastIndex = i;
                }
            }
        }

        System.out.println(maxLength);

        Stack<Integer> stack = new Stack<>();
        while (lastIndex != -1) {
            stack.push(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}