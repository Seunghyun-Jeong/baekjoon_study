package seunghyun;

import java.util.Scanner;

public class Backtracking4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (!(1 <= M && M <= N && N <= 8)) {
            throw new IllegalArgumentException();
        }

        int[] seq = new int[M];
        StringBuilder sb = new StringBuilder();
        generateSequence(N, M, 0, 1, seq, sb);
        System.out.println(sb.toString());
    }

    public static void generateSequence(int N, int M, int dep, int start, int[] seq, StringBuilder sb) {
        if (dep == M) {
            for (int num : seq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            seq[dep] = i;
            generateSequence(N, M, dep + 1, i, seq, sb);
        }
    }
}