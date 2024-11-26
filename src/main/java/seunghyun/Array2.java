package seunghyun;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        if (1 > N || N > 10000 || 1 > X || X > 10000) {
            throw new IllegalArgumentException();
        }

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
        String result = "";
        for (int i = 0; i < N; i++) {
            if (X > list[i]) {
                result = result + list[i] + " ";
            }
        }
        System.out.println(result);
    }
}