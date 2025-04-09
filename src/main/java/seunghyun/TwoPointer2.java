package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (-1000000000 > arr[i] || arr[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int closestSum = Integer.MAX_VALUE;
        int ans1 = arr[left];
        int ans2 = arr[right];
        while (right > left) {
            int sum = arr[left] + arr[right];

            if (Math.abs(closestSum) > Math.abs(sum)) {
                closestSum = sum;
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum == 0) {
                break;
            }

            if (0 > sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}