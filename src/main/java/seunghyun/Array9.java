package seunghyun;

import java.util.Scanner;

public class Array9 {
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

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;

            while (i < j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;

                i++;
                j--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
