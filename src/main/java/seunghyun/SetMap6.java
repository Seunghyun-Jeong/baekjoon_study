package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetMap6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 500000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        Set<String> noListenSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = sc.nextLine();
            if (name.length() > 20) {
                throw new IllegalArgumentException();
            }
            noListenSet.add(name);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = sc.nextLine();
            if (name.length() > 20) {
                throw new IllegalArgumentException();
            }
            if (noListenSet.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String noListenNoSee : result) {
            System.out.println(noListenNoSee);
        }
    }
}
