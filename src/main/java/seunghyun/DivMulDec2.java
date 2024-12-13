package seunghyun;

import java.util.ArrayList;
import java.util.Scanner;

public class DivMulDec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10000) {
            throw new IllegalArgumentException();
        }
        int K = sc.nextInt();
        if (1 > K || K > N) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }
        if (K > 0 && K <= divisors.size()) {
            System.out.println(divisors.get(K - 1));
        } else {
            System.out.println("0");
        }
    }
}
