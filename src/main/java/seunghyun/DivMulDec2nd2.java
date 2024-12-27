package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        if (1 > A || A > 100000000) {
            throw new IllegalArgumentException();
        }
        long B = sc.nextInt();
        if (1 > B || B > 100000000) {
            throw new IllegalArgumentException();
        }

        long gcd = 0;
        long a = A;
        long b = B;
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        gcd = a;
        long lcm = (A * B) / gcd;
        System.out.println(lcm);
    }
}
