package seunghyun;

import java.util.Scanner;

public class BinarySearch3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        long M = sc.nextLong();
        if (1 > M || M > 2000000000) {
            throw new IllegalArgumentException();
        }

        long[] treeHeights = new long[N];
        for (int i = 0; i < N; i++) {
            treeHeights[i] = sc.nextLong();
            if (0 > treeHeights[i] || treeHeights[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        long left = 0;
        long right = 1000000000;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            for (long height : treeHeights) {
                if (height > mid) {
                    total += (height - mid);
                }
            }

            if (total >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}