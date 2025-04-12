package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoPointer5 {
    private static int[] arr;
    private static int N, C;
    private static List<Integer> A, B;
    private static int index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (1 > N || N > 30) {
            throw new IllegalArgumentException();
        }
        C = sc.nextInt();
        if (0 > C || C > 1000000000) {
            throw new IllegalArgumentException();
        }

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (1 > arr[i] || arr[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        A = new ArrayList<>();
        B = new ArrayList<>();
        dfsA(0, 0);
        dfsB(N / 2, 0);

        Collections.sort(B);

        int answer = 0;
        for (int value : A) {
            index = -1;
            binarySearch(0, B.size() - 1, value);
            answer += index + 1;
        }

        System.out.println(answer);
    }

    private static void binarySearch(int l, int r, int AValue) {
        while (r >= l) {
            int mid = (l + r) / 2;
            if (C >= B.get(mid) + AValue) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    private static void dfsA(int i, int sum) {
        if (sum > C) {
            return;
        }
        if (i == N / 2) {
            A.add(sum);
            return;
        }

        dfsA(i + 1, sum);
        dfsA(i + 1, sum + arr[i]);
    }

    private static void dfsB(int i, int sum) {
        if (sum > C) {
            return;
        }
        if (i == N) {
            B.add(sum);
            return;
        }

        dfsB(i + 1, sum);
        dfsB(i + 1, sum + arr[i]);
    }
}