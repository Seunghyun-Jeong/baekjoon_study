package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N < 1 || N > 200000) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> que = new ArrayDeque<>();

        for (int i = N; i >= 1; i--) {
            if (i % 2 == 0) {
                que.addFirst(i);
            } else {
                que.addLast(i);
            }
        }

        while (!que.isEmpty()) {
            bw.write(que.pollFirst() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}