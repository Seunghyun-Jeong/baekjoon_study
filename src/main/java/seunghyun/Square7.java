package seunghyun;

import java.util.Scanner;

public class Square7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            if (A == 0 && B == 0 && C == 0) {
                break;
            }
            if (0 > A || A > 1000 || 0 > B || B > 1000 || 0 > C || C > 1000) {
                throw new IllegalArgumentException();
            }

            if (A + B <= C || A + C <= B || B + C <= A) {
                System.out.println("Invalid");
            } else if (A == B && B == C) {
                System.out.println("Equilateral");
            } else if (A == B || B == C || A == C) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
