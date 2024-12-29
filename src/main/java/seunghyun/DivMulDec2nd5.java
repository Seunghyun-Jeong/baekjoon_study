package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivMulDec2nd5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] testCases = new long[T];

        for (int i = 0; i < T; i++) {
            testCases[i] = Long.parseLong(br.readLine());
            if (0 > testCases[i] || testCases[i] > 4000000000L) {
                throw new IllegalArgumentException();
            }
        }

        for (long n : testCases) {
            if (n <= 2) {
                bw.write("2\n");
                continue;
            }
            if (n == 3) {
                bw.write("3\n");
                continue;
            }
            if (n % 2 == 0) {
                n++;
            }
            while (true) {
                if (isPrime(n)) {
                    bw.write(n + "\n");
                    break;
                }
                n += 2;
            }
        }
        bw.flush();
    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
