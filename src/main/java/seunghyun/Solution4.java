package seunghyun;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int difference = N / 2;
        int leftValue = difference;
        int rightValue = (N % 2 == 1) ? N - 1 : N;

        for (int i = 0; i < difference; i++) {
            System.out.print(leftValue-- + " ");
            System.out.print(rightValue-- + " ");
        }

        if (N % 2 == 1) {
            System.out.print(N);
        }
    }
}