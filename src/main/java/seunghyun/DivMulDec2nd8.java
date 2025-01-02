package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 2100000000) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            count++;
        }
        System.out.println(count);
    }
}
