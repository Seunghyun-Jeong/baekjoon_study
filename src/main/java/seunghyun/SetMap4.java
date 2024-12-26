package seunghyun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SetMap4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        int M = sc.nextInt();
        if (1 > M || M > 100000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        Map<String, Integer> nameToNumber = new HashMap<>();
        List<String> numberToName = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            numberToName.add("");
        }
        for (int i = 1; i <= N; i++) {
            String name = sc.nextLine();
            nameToNumber.put(name, i);
            numberToName.set(i, name);
        }

        for (int i = 0; i < M; i++) {
            String query = sc.nextLine();
            if (Character.isDigit(query.charAt(0))) {
                int number = Integer.parseInt(query);
                System.out.println(numberToName.get(number));
            } else {
                System.out.println(nameToNumber.get(query));
            }
        }
    }
}
