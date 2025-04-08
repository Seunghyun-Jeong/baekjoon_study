package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (1 > arr[i] || arr[i] > 1000000) {
                throw new IllegalArgumentException();
            }
        }

        int X = sc.nextInt();
        if (1 > X || X > 2000000) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int count = 0;
        while (right > left) {
            int sum = arr[left] + arr[right];

            if (sum == X) {
                count++;
                left++;
                right--;
            } else if (X > sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}