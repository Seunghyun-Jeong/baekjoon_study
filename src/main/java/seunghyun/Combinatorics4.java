package seunghyun;

import java.util.Scanner;

public class Combinatorics4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (0 > K || K > N) {
            throw new IllegalArgumentException();
        }

        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        int nFac = result;

        result = 1;
        for (int i = 1; i <= K; i++) {
            result *= i;
        }
        int kFac = result;

        result = 1;
        for (int i = 1; i <= (N - K); i++) {
            result *= i;
        }
        int nMinusKFac = result;

        result = nFac / (kFac * nMinusKFac);
        System.out.println(result);
    }
}
