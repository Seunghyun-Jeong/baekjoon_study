package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackQueueDeque1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (Integer.parseInt(command[0])) {
                case 1:
                    int X = Integer.parseInt(command[1]);
                    if (1 > X || X > 100000) {
                        throw new IllegalArgumentException();
                    }
                    stack.push(X);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
