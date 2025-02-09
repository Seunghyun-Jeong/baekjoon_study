package seunghyun;

import java.util.Scanner;

public class DynamicProgramming4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] pado = new long[101];
        pado[1] = pado[2] = pado[3] = 1;
        pado[4] = pado[5] = 2;

        for (int i = 6; i <= 100; i++) {
            pado[i] = pado[i - 1] + pado[i - 5];
        }

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            if (1 > N || N > 100) {
                throw new IllegalArgumentException();
            }
            System.out.println(pado[N]);
        }
    }
}