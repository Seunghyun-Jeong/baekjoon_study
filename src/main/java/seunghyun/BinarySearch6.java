package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < A[i]) {
                list.add(A[i]);
            } else {
                int pos = Collections.binarySearch(list, A[i]);
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                list.set(pos, A[i]);
            }
        }
        System.out.println(list.size());
    }
}