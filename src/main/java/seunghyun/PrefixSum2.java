package seunghyun;

import java.util.Scanner;

public class PrefixSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > N) {
            throw new IllegalArgumentException();
        }

        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = sc.nextInt();
            if (-100 > temp[i] || temp[i] > 100) {
                throw new IllegalArgumentException();
            }
        }

        int current = 0;
        for (int i = 0; i < K; i++) {
            current += temp[i];
        }

        int maxSum = current;
        for (int i = K; i < N; i++) {
            current = current - temp[i - K] + temp[i];
            if (current > maxSum) {
                maxSum = current;
            }
        }

        System.out.println(maxSum);
    }
}