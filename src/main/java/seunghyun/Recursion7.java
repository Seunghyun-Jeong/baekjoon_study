package seunghyun;

import java.util.Scanner;

public class Recursion7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 20) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        int move = hanoi(N, 1, 3, 2, sb);
        System.out.println(move);
        System.out.print(sb.toString());
    }

    public static int hanoi(int N, int start, int end, int aux, StringBuilder sb) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return 1;
        }

        int move = 0;
        move += hanoi(N - 1, start, aux, end, sb);
        sb.append(start).append(" ").append(end).append("\n");
        move += 1;
        move += hanoi(N - 1, aux, end, start, sb);

        return move;
    }
}