package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Advanced2nd5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int M = Integer.parseInt(st.nextToken());
        if (1 > M || M > 10) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(count.keySet());
        words.sort((w1, w2) -> {
            int countComparison = count.get(w2).compareTo(count.get(w1));
            if (countComparison == 0) {
                int lengthComparison = Integer.compare(w2.length(), w1.length());
                if (lengthComparison == 0) {
                    return w1.compareTo(w2);
                }
                return lengthComparison;
            }
            return countComparison;
        });
        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
    }
}
