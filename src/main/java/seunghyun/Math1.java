package seunghyun;

import java.util.Scanner;

public class Math1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();

        int result = 0;
        for (int i = 0; i < N.length(); i++) {
            char ch = N.charAt(i);
            int value;
            if (ch >= '0' && ch <= '9') {
                value = ch -'0';
            } else {
                value = ch - 'A' + 10;
            }
            result = result * B + value;
        }
        System.out.println(result);
    }
}
