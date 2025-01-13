package seunghyun;

import java.util.Scanner;

public class Combinatorics5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (!(0 < N && N <= M && M < 30)) {
                throw new IllegalArgumentException();
            }

            int result = 1;
            for (int j = 0; j < N; j++) {
                result *= (M - j);
                result /= (j + 1);
            }
            System.out.println(result);
        }
    }
}
