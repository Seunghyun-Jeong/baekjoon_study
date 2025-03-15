package seunghyun;

import java.util.Scanner;
import java.util.Stack;

public class Stack2nd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String bomb = sc.nextLine();
        int bombLength = bomb.length();
        char lastChar = bomb.charAt(bombLength - 1);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= bombLength && stack.peek() == lastChar) {
                boolean isMatch = true;

                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }
            System.out.println(result);
        }
    }
}