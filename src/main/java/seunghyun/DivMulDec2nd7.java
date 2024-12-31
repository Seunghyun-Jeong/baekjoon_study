package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = 123456 * 2;
        boolean[] isPrime = new boolean[limit + 1];

        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if (1 > n || n > 123456) {
                throw new IllegalArgumentException();
            }
            int count = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
