package seunghyun;

import java.util.Scanner;

public class BinarySearch5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > Math.min(1000000000, (long) N * N)) {
            throw new IllegalArgumentException();
        }

        long left = 1;
        long right = (long) N * N;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= K) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}