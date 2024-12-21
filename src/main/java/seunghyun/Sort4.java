package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Sort4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();
        for (int result : input) {
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
