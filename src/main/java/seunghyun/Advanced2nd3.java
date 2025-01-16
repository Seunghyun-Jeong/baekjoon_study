package seunghyun;

import java.util.HashSet;
import java.util.Scanner;

public class Advanced2nd3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        HashSet<String> input = new HashSet<>();
        input.add("ChongChong");
        for (int i = 0; i < N; i++) {
            String A = sc.next();
            String B = sc.next();
            if (input.contains(A) || input.contains(B)) {
                input.add(A);
                input.add(B);
            }
        }
        System.out.println(input.size());
    }
}
