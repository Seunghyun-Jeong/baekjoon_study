package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrefixSum3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int SLen = S.length();
        if (SLen > 200000) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < SLen; i++) {
            if (S.charAt(i) < 'a' || S.charAt(i) > 'z') {
                throw new IllegalArgumentException();
            }
        }

        int[][] freq = new int[26][SLen + 1];
        for (int i = 0; i < SLen; i++) {
            for (int j = 0; j < 26; j++) {
                freq[j][i + 1] = freq[j][i];
            }
            freq[S.charAt(i) - 'a'][i + 1]++;
        }

        int q = Integer.parseInt(br.readLine());
        if (1 > q || q > 200000) {
            throw new IllegalArgumentException();
        }
        for (int k = 0; k < q; k++) {
            String[] query = br.readLine().split(" ");
            char alpha = query[0].charAt(0);
            int l = Integer.parseInt(query[1]);
            int r = Integer.parseInt(query[2]);
            if (alpha < 'a' || alpha > 'z') {
                throw new IllegalArgumentException();
            }
            if (0 > l || l > r || r >= SLen) {
                throw new IllegalArgumentException();
            }
            int count = freq[alpha - 'a'][r + 1] - freq[alpha - 'a'][l];
            bw.write(count+ "\n");
        }
        bw.flush();
    }
}