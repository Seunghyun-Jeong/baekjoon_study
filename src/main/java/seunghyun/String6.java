package seunghyun;

import java.util.Scanner;

public class String6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int[] positions = new int[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';
            if (positions[index] == -1) {
                positions[index] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(positions[i] + " ");
        }
    }
}
