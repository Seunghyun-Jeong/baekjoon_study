package seunghyun;

import java.util.Scanner;

public class String9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String reverse = "";

        for (int i = input.length()-1; i >= 0; i--) {
            reverse += input.charAt(i);
        }

        String[] S = reverse.split(" ");
        int A = Integer.parseInt(S[0]);
        int B = Integer.parseInt(S[1]);

        if (A > B) {
            System.out.println(A);
        } else {
            System.out.println(B);
        }
    }
}
