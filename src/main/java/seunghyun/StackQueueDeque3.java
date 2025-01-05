package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class StackQueueDeque3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String ps = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char ch : ps.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                isValid = false;
            }
            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
