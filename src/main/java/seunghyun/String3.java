package seunghyun;

import java.util.Scanner;

public class String3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        if (1 > T || T > 10) {
            throw new IllegalArgumentException();
        }

        int length = 0;
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            length = input.length();
            System.out.print(input.charAt(0));
            System.out.println(input.charAt(length-1));
        }
    }
}
