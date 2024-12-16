package seunghyun;

import java.util.Scanner;

public class Square4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (1 > n || n > 1000000000) {
            throw new IllegalArgumentException();
        }

        long result = 4 * n;
        System.out.println(result);
    }
}
