package seunghyun;

import java.util.Scanner;

public class TwoPointer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (10 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int S = sc.nextInt();
        if (0 > S || S > 100000000) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (1 > arr[i] || arr[i] > 10000) {
                throw new IllegalArgumentException();
            }
        }

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}