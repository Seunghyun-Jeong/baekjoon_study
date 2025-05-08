package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 1 || N > 1000000) {
            throw new IllegalArgumentException();
        }

        char[] arr = new char[N];
        Arrays.fill(arr, 'a');
        System.out.println(arr);
    }
}