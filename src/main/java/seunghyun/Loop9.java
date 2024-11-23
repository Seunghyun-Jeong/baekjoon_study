package seunghyun;

import java.util.Scanner;

public class Loop9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (1 > N || N > 100) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i <= N; i++) {
            String stars = "";
            for (int j = 0; j < i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
    }
}