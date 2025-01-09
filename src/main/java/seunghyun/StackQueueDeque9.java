package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class StackQueueDeque9 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (Integer.parseInt(input[0])) {
                case 1:
                    int X1 = Integer.parseInt(input[1]);
                    if (1 > X1 || X1 > 100000) {
                        throw new IllegalArgumentException();
                    }
                    deque.addFirst(X1);
                    break;
                case 2:
                    int X2 = Integer.parseInt(input[1]);
                    if (1 > X2 || X2 > 100000) {
                        throw new IllegalArgumentException();
                    }
                    deque.addLast(X2);
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;
                case 5:
                    bw.write(deque.size() + "\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
