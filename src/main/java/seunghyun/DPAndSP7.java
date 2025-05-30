package seunghyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DPAndSP7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if (0 > A || A > 10000) {
                throw new IllegalArgumentException();
            }
            int B = Integer.parseInt(st.nextToken());
            if (0 > B || B > 10000 || A == B) {
                throw new IllegalArgumentException();
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            queue.add(A);
            visited[A] = true;
            Arrays.fill(command, "");
            while (!queue.isEmpty() && !visited[B]) {
                int now = queue.poll();

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    command[D] = command[now] + "D";
                }

                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }

                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }
            System.out.println(command[B]);
        }
    }
}