package seunghyun;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int max = list[0];
        int min = list[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, list[i]);
            min = Math.min(min, list[i]);
        }
        System.out.println(min + " " + max);
    }
}
