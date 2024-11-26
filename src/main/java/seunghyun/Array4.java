package seunghyun;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list = new int[9];
        for (int i = 0; i < 9; i++) {
            list[i] = sc.nextInt();
            if (1 > list[i] || list[i] > 100 ) {
                throw new IllegalArgumentException();
            }
        }

        int max = list[0];
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, list[i]);
        }

        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (max == list[i]) {
                count = i+1;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
}