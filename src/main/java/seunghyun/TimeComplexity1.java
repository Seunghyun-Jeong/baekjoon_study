package seunghyun;

import java.util.Scanner;

public class TimeComplexity1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (1 > n || n > 500000) {
            throw new IllegalArgumentException();
        }

        System.out.println(1);
        System.out.println(0);
    }
}
