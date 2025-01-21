package seunghyun;

import java.util.Scanner;

public class Recursion3 {
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (1 > T || T > 1000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String S = sc.nextLine();
            count = 0;
            int result = isPalindrome(S);
            System.out.println(result + " " + count);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return recursion(s, l + 1, r - 1);
        }
    }
}
