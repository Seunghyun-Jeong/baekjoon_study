package seunghyun;

import java.util.Scanner;

public class BruteForce6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (3 > N || N > 5000) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }
            N -= 3;
            count ++;
            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
