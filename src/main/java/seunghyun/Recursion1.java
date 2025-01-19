package seunghyun;

import java.util.Scanner;

public class Recursion1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if (0 > N || N > 20) {
            throw new IllegalArgumentException();
        }

        Long result = factorial(N);
        System.out.println(result);
    }
    public static long factorial(long N) {
        if (N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}
