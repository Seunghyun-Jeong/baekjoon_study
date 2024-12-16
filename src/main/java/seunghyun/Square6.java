package seunghyun;

import java.util.Scanner;

public class Square6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (0 >= A || A >= 180) {
            throw new IllegalArgumentException();
        }
        if (0 >= B || B >= 180) {
            throw new IllegalArgumentException();
        }
        if (0 >= C || C >= 180) {
            throw new IllegalArgumentException();
        }

        int sum = A + B + C;
        if (sum != 180) {
            System.out.println("Error");
        } else if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
        } else if (A == B || B == C || A == C) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
