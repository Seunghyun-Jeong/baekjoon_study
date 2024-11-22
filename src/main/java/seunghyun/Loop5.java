package seunghyun;

import java.util.Scanner;

public class Loop5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (4 > N || N > 1000 || N % 4 != 0) {
            throw new IllegalArgumentException();
        }

        int count = N / 4;

        for (int i = 0; i < count; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
