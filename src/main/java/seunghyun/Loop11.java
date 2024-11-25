package seunghyun;

import java.util.Scanner;

public class Loop11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (0 > A || A > 10 || 0 > B || B > 10) {
                throw new IllegalArgumentException();
            }
            if (A == 0 || B == 0) {
                break;
            }
            sum = A + B;
            System.out.println(sum);
        }
    }
}