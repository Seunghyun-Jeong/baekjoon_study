package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SetMap5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 500000) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> currentCards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (-10000000 > input || input > 10000000) {
                throw new IllegalArgumentException();
            }
            currentCards.put(input, currentCards.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        if (1 > M || M > 500000) {
            throw new IllegalArgumentException();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (-10000000 > input || input > 10000000) {
                throw new IllegalArgumentException();
            }
            bw.write(currentCards.getOrDefault(input, 0) + " ");
        }
        bw.flush();
    }
}
