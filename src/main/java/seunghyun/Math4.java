package seunghyun;

import java.util.Scanner;

public class Math4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N > 15 || 1 > N) {
            throw new IllegalArgumentException();
        }

        int points = 4;
        for (int i = 0; i < N; i++) {
            points = (int) Math.pow(Math.sqrt(points) + (Math.sqrt(points) -1), 2);
        }
        System.out.println(points);
    }
}
