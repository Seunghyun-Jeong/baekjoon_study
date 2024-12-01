package seunghyun;

import java.util.Scanner;

public class String7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.nextLine().trim();

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    result.append(S.charAt(j));
                }
            }

            System.out.println(result);
        }
    }
}
