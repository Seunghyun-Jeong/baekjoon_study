package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500000) {
            throw new IllegalArgumentException();
        }
        
        Set<Integer> card = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (-10000000 > input || input > 10000000) {
                throw new IllegalArgumentException();
            }
            card.add(input);
        }

        int M = sc.nextInt();
        if (1 > M || M > 500000) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < M; i++) {
            int input = sc.nextInt();
            if (card.contains(input)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
