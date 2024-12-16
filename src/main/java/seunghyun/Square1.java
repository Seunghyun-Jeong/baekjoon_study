package seunghyun;

import java.util.Scanner;

public class Square1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if (1 > A || A > 100 || 1 > B || B > 100) {
            throw new IllegalArgumentException();
        }
        System.out.println(A*B);
    }
}
