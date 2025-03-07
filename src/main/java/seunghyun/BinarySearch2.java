package seunghyun;

import java.util.Scanner;

public class BinarySearch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        if (1 > K || K > 10000) {
            throw new IllegalArgumentException();
        }
        int N = sc.nextInt();
        if (1 > N || N > 1000000 || K > N) {
            throw new IllegalArgumentException();
        }

        int[] lanCables = new int[K];
        for (int i = 0; i < K; i++) {
            lanCables[i] = sc.nextInt();
        }

        long max = 0;
        for (int length : lanCables) {
            if (length > max) {
                max = length;
            }
        }

        long left = 1;
        long right = max;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int length : lanCables) {
                count += length / mid;
            }

            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}