package seunghyun;

import java.util.Scanner;

public class Math2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (N > 0) {
            result.append(digits.charAt(N % B));
            N /= B;
        }
        System.out.println(result.reverse().toString());
    }
}
