package seunghyun;

import java.util.Scanner;

public class Loop7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int sum = 0;
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (0 > A || A > 10 || 0 > B || B > 10) {
                throw new IllegalArgumentException();
            }
            sum = A + B;
            System.out.println("Case #" + i + ": " + sum);
        }
    }
}
