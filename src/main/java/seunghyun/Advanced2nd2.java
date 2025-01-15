package seunghyun;

import java.util.HashSet;
import java.util.Scanner;

public class Advanced2nd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        HashSet<String> users = new HashSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            if (input.equals("ENTER")) {
                users.clear();
            } else {
                if (!users.contains(input)) {
                    users.add(input);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
