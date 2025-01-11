package seunghyun;

import java.util.Scanner;

public class Combinatorics3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (0 > N || N > 12) {
            throw new IllegalArgumentException();
        }

        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
