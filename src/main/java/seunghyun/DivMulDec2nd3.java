package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        if (1 > A || A > 30000) {
            throw new IllegalArgumentException();
        }
        int B = sc.nextInt();
        if (1 > B || B > 30000) {
            throw new IllegalArgumentException();
        }
        int C = sc.nextInt();
        if (1 > C || C > 30000) {
            throw new IllegalArgumentException();
        }
        int D = sc.nextInt();
        if (1 > D || D > 30000) {
            throw new IllegalArgumentException();
        }

        int denominator = B * D;
        int sum = (A * D) + (C * B);
        int a = sum;
        int b = denominator;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        int resultNumerator = sum / gcd;
        int resultDenominator = denominator / gcd;
        System.out.println(resultNumerator + " " + resultDenominator);
    }
}
