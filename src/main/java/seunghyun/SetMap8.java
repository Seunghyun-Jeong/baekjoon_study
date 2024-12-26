package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMap8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        if (S.length() > 1000) {
            throw new IllegalArgumentException();
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <=  S.length(); j++) {
                result.add(S.substring(i, j));
            }
        }
        System.out.println(result.size());
    }
}
