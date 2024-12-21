package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 10000000) {
            throw new IllegalArgumentException();
        }

        int[] input = new int[10001];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            input[number]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10000; i++) {
            while (input[i] > 0) {
                sb.append(i).append('\n');
                input[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
