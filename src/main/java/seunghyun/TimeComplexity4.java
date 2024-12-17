package seunghyun;

import java.util.Scanner;

public class TimeComplexity4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        if (1 > n || n > 500000) {
            throw new IllegalArgumentException();
        }

        System.out.println((n * (n - 1)) / 2);
        System.out.println(2);
    }
}
