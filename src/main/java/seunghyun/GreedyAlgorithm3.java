package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyAlgorithm3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            if (1 > P[i] || P[i] > 1000) {
                throw new IllegalArgumentException();
            }
        }

        Arrays.sort(P);

        int totalTime = 0;
        int accTime = 0;
        for (int i = 0; i < N; i++) {
            accTime += P[i];
            totalTime += accTime;
        }

        System.out.println(totalTime);
    }
}