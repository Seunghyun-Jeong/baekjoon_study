package seunghyun;

import java.util.Scanner;

public class BruteForce3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        if (-999 > a || a > 999 || -999 > b || b > 999 || -999 > c || c > 999 || -999 > d || d > 999 || -999 > e || e > 999 || -999 > f || f > 999) {
            throw new IllegalArgumentException();
        }

        int denominator = (a * e) - (b * d);
        int x = (c * e - b * f) / denominator;
        int y = (a * f - c * d) / denominator;
        System.out.println(x + " " + y);
    }
}
