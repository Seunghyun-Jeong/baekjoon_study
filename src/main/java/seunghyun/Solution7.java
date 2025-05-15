package seunghyun;

import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        if(n == 1) {
            if(k == 0) {
                System.out.println("1");
            } else {
                System.out.println("Impossible");
            }
            return;
        }

        if(k > n - 1) {
            System.out.println("Impossible");
            return;
        }

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i + 1;
        }

        int needed = (n - 1) - k;
        for (int i = 1; i <= needed; i++) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(A[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}