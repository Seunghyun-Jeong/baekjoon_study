package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Advanced8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int groupWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            Set<Character> appearedChars = new HashSet<>();
            char previousChar = word.charAt(0);
            appearedChars.add(previousChar);

            boolean isGroupWord = true;

            for (int j = 1; j < word.length(); j++) {
                char currentChar = word.charAt(j);

                if (currentChar != previousChar && appearedChars.contains(currentChar)) {
                    isGroupWord = false;
                    break;
                }

                if (currentChar != previousChar) {
                    appearedChars.add(currentChar);
                }
                previousChar = currentChar;
            }
            if (isGroupWord) {
                groupWordCount++;
            }
        }
        System.out.println(groupWordCount);
    }
}
