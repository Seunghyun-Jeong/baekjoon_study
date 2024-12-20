package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Sort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = sc.nextInt();
        }
        Arrays.sort(result);
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
