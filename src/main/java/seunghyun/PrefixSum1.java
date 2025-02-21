package seunghyun;

import java.util.Scanner;

public class PrefixSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 100000) {
            throw new IllegalArgumentException();
        }

        int[] numbers = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
            if (1 > numbers[i] || numbers[i] > 1000) {
                throw new IllegalArgumentException();
            }
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            if (1 > i || i > j || j > N) {
                throw new IllegalArgumentException();
            }
            int sum = prefixSum[j] - prefixSum[i - 1];
            System.out.println(sum);
        }
    }
}