package seunghyun;

import java.util.Scanner;

public class BruteForce1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cards = new int[N];
        if (3 > N || N > 100) {
            throw new IllegalArgumentException();
        }
        if (10 > M || M > 300000) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int maxSum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}
