package seunghyun;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == target) {
                count++;
            }
        }
        System.out.println(count);
    }
}