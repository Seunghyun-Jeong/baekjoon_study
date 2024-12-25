package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 10000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 10000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(sc.nextLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
