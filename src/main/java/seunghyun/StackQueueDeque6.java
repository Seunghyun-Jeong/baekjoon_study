package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueDeque6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 2000000) {
            throw new IllegalArgumentException();
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    int X = Integer.parseInt(input[1]);
                    if (1 > X || X > 100000) {
                        throw new IllegalArgumentException();
                    }
                    queue.offer(X);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(((LinkedList<Integer>) queue).getLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
