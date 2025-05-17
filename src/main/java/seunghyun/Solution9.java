package seunghyun;

import java.util.Scanner;

public class Solution9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int L = (int) Math.ceil(Math.sqrt(N));
        int K = 2 * L - 1;
        System.out.println(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L; i++) {
            sb.append("1 ");
        }
        for (int i = 0; i < L - 1; i++) {
            sb.append(L);
            if(i < L - 2) sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}