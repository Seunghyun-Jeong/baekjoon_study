package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 200000) {
            throw new IllegalArgumentException();
        }
        int C = sc.nextInt();
        if (2 > C || C > N) {
            throw new IllegalArgumentException();
        }

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
            if (0 > houses[i] || houses[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        Arrays.sort(houses);
        int left = 1;
        int right = houses[N - 1] - houses[0];
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int lastInstalled = houses[0];

            for (int i = 1; i < N; i++) {
                if (houses[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = houses[i];
                }
            }

            if (count >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}