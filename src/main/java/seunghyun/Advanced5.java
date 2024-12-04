package seunghyun;

import java.util.Scanner;

public class Advanced5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.length() > 1000000) {
            throw new IllegalArgumentException();
        }

        input = input.toUpperCase();
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                count[c - 'A']++;
            }
        }

        int maxCount = 0;
        char mostFrequentChar = '?';
        boolean isMultiple = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mostFrequentChar = (char)(i + 'A');
                isMultiple = false;
            } else if (count[i] == maxCount) {
                isMultiple = true;
            }
        }

        if (isMultiple) {
            System.out.println("?");
        } else {
            System.out.println(mostFrequentChar);
        }
    }
}
