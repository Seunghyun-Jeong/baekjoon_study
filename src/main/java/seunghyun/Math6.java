package seunghyun;

import java.util.Scanner;

public class Math6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        if (1 > X || X > 10000000) {
            throw new IllegalArgumentException();
        }

        int numerator = 1;
        int denominator = 1;
        int count = 1;
        while (count < X) {
            if ((numerator + denominator) % 2 == 1) {
                if (denominator == 1) {
                    numerator++;
                } else {
                    numerator++;
                    denominator--;
                }
            } else {
                if (numerator == 1) {
                    denominator++;
                } else {
                    numerator--;
                    denominator++;
                }
            }
            count++;
        }
        System.out.println(numerator + "/" + denominator);
    }
}
