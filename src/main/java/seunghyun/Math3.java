package seunghyun;

import java.util.Scanner;

public class Math3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int Q = 0;
        int D = 0;
        int N = 0;
        int P = 0;

        for (int i = 0; i < T; i++) {
            int input = sc.nextInt();
            Q = input / 25;
            int result = input % 25;
            D = result / 10;
            result %= 10;
            N = result / 5;
            result %= 5;
            P = result / 1;
            System.out.println(Q + " " + D + " " + N + " " + P);
        }
    }
}
