package seunghyun;

import java.util.HashMap;
import java.util.Scanner;

public class PrefixSum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (2 > M || M > 1000) {
            throw new IllegalArgumentException();
        }

        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            long A = sc.nextLong();
            if (0 > A || A > 1000000000) {
                throw new IllegalArgumentException();
            }
            prefixSum[i] = (prefixSum[i - 1] + A) % M;
        }

        HashMap<Long, Long> modCount = new HashMap<>();
        long count = 0;
        for (int i = 0; i <= N; i++) {
            Long mod = prefixSum[i];
            if (mod < 0) {
                mod += M;
            }
            count += modCount.getOrDefault(mod, 0L);
            modCount.put(mod, modCount.getOrDefault(mod, 0L) + 1);
        }

        System.out.println(count);
    }
}