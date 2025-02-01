package seunghyun;

import java.util.Scanner;

public class BackTracking3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (!(1 <= M && M <= N && N <= 7)) {
            throw new IllegalArgumentException();
        }

        int[] seq = new int[M];
        StringBuilder sb = new StringBuilder();
        generateSequence(N, M, 0,  seq, sb);
        System.out.print(sb.toString());
    }

    public static void generateSequence(int N, int M, int depth, int[] seq, StringBuilder sb) {
        if (depth == M) {
            for (int num : seq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            seq[depth] = i;
            generateSequence(N, M, depth + 1, seq, sb);
        }
    }
}