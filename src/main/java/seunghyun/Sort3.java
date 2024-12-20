package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Sort3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        int k = sc.nextInt();
        if (1 > k || k > N) {
            throw new IllegalArgumentException();
        }
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            if (0 > x[i] || x[i] > 10000) {
                throw new IllegalArgumentException();
            }
        }
        Arrays.sort(x);
        System.out.println(x[N - k]);
    }
}
