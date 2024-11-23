package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Loop6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int sum = 0;
            String input = br.readLine();
            String array[] = input.split(" ");
            for (String str : array) {
                sum += Integer.parseInt(str);
            }
            bw.write(Integer.toString(sum));
            bw.newLine();
        }
        bw.flush();
    }
}
