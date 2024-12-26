package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMap7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNumber = sc.nextInt();
        if (1 > aNumber || aNumber > 200000) {
            throw new IllegalArgumentException();
        }
        int bNumber = sc.nextInt();
        if (1 > bNumber || bNumber > 200000) {
            throw new IllegalArgumentException();
        }

        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < aNumber; i++) {
            int input = sc.nextInt();
            if (input > 100000000) {
                throw new IllegalArgumentException();
            }
            A.add(input);
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < bNumber; i++) {
            int input = sc.nextInt();
            if (input > 100000000) {
                throw new IllegalArgumentException();
            }
            B.add(input);
        }

        Set<Integer> AMinusB = new HashSet<>(A);
        AMinusB.removeAll(B);

        Set<Integer> BMinusA = new HashSet<>(B);
        BMinusA.removeAll(A);

        int result = AMinusB.size() + BMinusA.size();
        System.out.println(result);
    }
}
