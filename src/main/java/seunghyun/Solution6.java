package seunghyun;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        BigInteger[] fib = new BigInteger[N + 1];
        fib[1] = BigInteger.ONE;
        if (N >= 2) {
            fib[2] = BigInteger.ONE;
        }
        for (int i = 3; i <= N; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            indices.add(i);
        }
        if ((N + 2) % 3 == 0) {
            indices.remove(Integer.valueOf(2));
        }

        indices.sort(Collections.reverseOrder());
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        BigInteger sumA = BigInteger.ZERO, sumB = BigInteger.ZERO;

        for (int idx : indices) {
            if (sumA.compareTo(sumB) <= 0) {
                groupA.add(idx);
                sumA = sumA.add(fib[idx]);
            } else {
                groupB.add(idx);
                sumB = sumB.add(fib[idx]);
            }
        }

        Collections.sort(groupA);
        Collections.sort(groupB);

        System.out.println(groupA.size());
        for (int idx : groupA) {
            System.out.print(idx + " ");
        }
        System.out.println();

        System.out.println(groupB.size());
        for (int idx : groupB) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }
}