package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class DPAndSP4 {
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        int length1 = input1.length();
        if (length1 > 1000) {
            throw new IllegalArgumentException();
        }
        String input2 = sc.nextLine();
        int length2 = input2.length();
        if (length2 > 1000) {
            throw new IllegalArgumentException();
        }

        dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[length1][length2]);
        printLCS(input1, length1, length2);
    }

    private static void printLCS(String str, int i, int j) {
        Stack<Character> stack = new Stack<>();

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                stack.push(str.charAt(i - 1));
                i--;
                j--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}