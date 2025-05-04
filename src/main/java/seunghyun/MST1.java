package seunghyun;

import java.util.Scanner;

public class MST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            if (2 > N || N > 1000) {
                throw new IllegalArgumentException();
            }
            int M = sc.nextInt();
            if (1 > M || M > 10000) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                if (1 > a || a > N) {
                    throw new IllegalArgumentException();
                }
                int b = sc.nextInt();
                if (1 > b || b > N || a == b) {
                    throw new IllegalArgumentException();
                }
            }

            System.out.println(N - 1);
        }
    }
}