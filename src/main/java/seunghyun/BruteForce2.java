package seunghyun;

import java.util.Scanner;

public class BruteForce2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        int result = 0;

        for (int M = 1; M <= N; M++) {
            int sum = M;
            int temp = M;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                result = M;
                break;
            }
        }
        System.out.println(result);
    }
}
