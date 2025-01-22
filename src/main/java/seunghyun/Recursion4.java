package seunghyun;

import java.util.Scanner;

public class Recursion4 {
    static int[] arr;
    static int[] temp;
    static int count = 0;
    static int K;
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (5 > N || N > 500000) {
            throw new IllegalArgumentException();
        }
        K = sc.nextInt();
        if (1 > K || K > 100000000) {
            throw new IllegalArgumentException();
        }

        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, N - 1);
        System.out.println(result);
    }

    public static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = p;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= q) {
            temp[t++] = arr[i++];
        }

        while (j <= r) {
            temp[t++] = arr[j++];
        }

        for (i = p; i <= r; i++) {
            arr[i] = temp[i];
            count++;
            if (count == K) {
                result = arr[i];
                return;
            }
        }
    }
}
