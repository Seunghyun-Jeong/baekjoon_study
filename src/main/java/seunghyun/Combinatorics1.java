package seunghyun;

import java.util.Scanner;

public class Combinatorics1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = N * (N - 1);
        System.out.println(result);
    }
}
