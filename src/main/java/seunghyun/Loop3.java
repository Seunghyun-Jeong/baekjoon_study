package seunghyun;

import java.util.Scanner;

public class Loop3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        if (N > 10000 || 1 > N) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i <= N; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
