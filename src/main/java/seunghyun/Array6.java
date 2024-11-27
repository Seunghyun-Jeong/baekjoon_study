package seunghyun;

import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (1 > N || N > 100 || 1 > M || M > 100) {
            throw new IllegalArgumentException();
        }

        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int temp = baskets[a-1];
            baskets[a-1] = baskets[b-1];
            baskets[b-1] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}