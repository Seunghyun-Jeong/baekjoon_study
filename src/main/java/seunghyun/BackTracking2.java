package seunghyun;

import java.util.Scanner;

public class BackTracking2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (!(1 <= M && M <= N && N <= 8)) {
            throw new IllegalArgumentException();
        }

        int[] seq = new int[M];
        generateSequence(N, M, 0, 1, seq);
    }

    public static void generateSequence(int N, int M, int depth, int start, int[] seq) {
        if (depth == M) {
            for (int num : seq) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            seq[depth] = i;
            generateSequence(N, M, depth + 1, i + 1, seq);
        }
    }
}