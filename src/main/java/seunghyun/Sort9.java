package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Sort9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(sc.nextLine());
        }

        List<String> list = new ArrayList<>(words);
        Collections.sort(list, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return Integer.compare(a.length(), b.length());
            }
        });

        for (String word : list) {
            System.out.println(word);
        }
    }
}
