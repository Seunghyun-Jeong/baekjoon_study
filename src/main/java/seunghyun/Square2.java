package seunghyun;

import java.util.Scanner;

public class Square2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        if (1 > x || x > w-1 || 1 > y || y > h-1 || 1 > w || w > 1000 || 1 > h || h > 1000) {
            throw new IllegalArgumentException();
        }

        int left = x;
        int right = w - x;
        int bottom = y;
        int top = h - y;
        int minDistance = Math.min(Math.min(left, right), Math.min(bottom, top));

        System.out.println(minDistance);
    }
}
