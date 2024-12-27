package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (1 > T || T > 1000) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            if (1 > A || A > 45000) {
                throw new IllegalArgumentException();
            }
            int B = sc.nextInt();
            if (1 > B || B > 45000) {
                throw new IllegalArgumentException();
            }

            int lcm = 0;
            int max = Math.max(A, B);
            int multiple = max;
            while (true) {
                if (multiple % A == 0 && multiple % B == 0) {
                    lcm = multiple;
                    break;
                }
                multiple += max;
            }
            System.out.println(lcm);
        }
    }
}
