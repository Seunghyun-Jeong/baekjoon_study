package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.nextLine();
            list.add(new String[]{String.valueOf(age), name});
        }

        list.sort((a, b) -> {
            int age1 = Integer.parseInt(a[0]);
            int age2 = Integer.parseInt(b[0]);
            if (age1 != age2) {
                return age1 - age2;
            } else {
                return 0;
            }
        });

        for (String[] member : list) {
            System.out.println(member[0] + member[1]);
        }
    }
}
