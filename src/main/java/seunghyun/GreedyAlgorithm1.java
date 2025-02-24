package seunghyun;

import java.util.Scanner;

public class GreedyAlgorithm1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > 100000000) {
            throw new IllegalArgumentException();
        }

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
            if (1 > coins[i] || coins[i] > 1000000) {
                throw new IllegalArgumentException();
            }
            if (i > 0 && coins[i] % coins[i - 1] != 0) {
                throw new IllegalArgumentException();
            }
        }

        int coinCount = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                coinCount += K / coins[i];
                K %= coins[i];
            }
        }

        System.out.println(coinCount);
    }
}