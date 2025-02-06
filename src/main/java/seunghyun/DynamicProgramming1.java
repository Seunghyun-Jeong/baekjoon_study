package seunghyun;

import java.util.Scanner;

public class DynamicProgramming1 {
    private static int recursiveCount = 0;
    private static int dynamicCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (5 > N || N > 40) {
            throw new IllegalArgumentException();
        }

        fib(N);
        fibonacci(N);
        System.out.println(recursiveCount + " " + dynamicCount);
    }

    public static int fib(int N) {
        if (N == 1 || N == 2) {
            recursiveCount++;
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public static int fibonacci(int N) {
        int[] f = new int[N + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= N; i++) {
            dynamicCount++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N];
    }
}