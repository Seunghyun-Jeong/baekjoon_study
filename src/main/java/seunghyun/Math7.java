package seunghyun;

import java.util.Scanner;

public class Math7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        if (!(1 <= B && B < A && A <= V && V <= 1000000000)) {
            throw new IllegalArgumentException();
        }

        int climb = A - B;
        int days = (V - B) / climb;
        if ((V-B) % climb != 0) {
            days++;
        }
        System.out.println(days);
    }
}
