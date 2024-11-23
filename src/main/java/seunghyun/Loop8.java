package seunghyun;

import java.util.Scanner;

public class Loop8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int C = 0;
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (1 > A || A > 10 || 1 > B || B > 10) {
                throw new IllegalArgumentException();
            }
            C = A + B;
            System.out.println("Case #" + i + ": " + A + " + " + B + " = " + C);
        }
    }
}
