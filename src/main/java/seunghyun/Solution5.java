package seunghyun;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(str);
        }

        System.out.println(sb.toString());
    }
}