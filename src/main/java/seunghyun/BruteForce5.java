package seunghyun;

import java.util.Scanner;

public class BruteForce5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10000) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        int number = 666;
        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }
            if (count == N) {
                break;
            }
            number++;
        }
        System.out.println(number);
    }
}
