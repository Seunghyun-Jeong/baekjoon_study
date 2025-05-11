package seunghyun;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 3 || N > 5000) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[N];
        int left = 1;
        int right = N;
        int index = 0;

        while (left <= right) {
            result[index++] = left++;
            if (left <= right) {
                result[index++] = right--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}