package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetMap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (2 > n || n > 1000000) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        Set<String> input = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] log = sc.nextLine().split(" ");
            String name = log[0];
            String attend = log[1];
            if (attend.equals("enter")) {
                input.add(name);
            } else if (attend.equals("leave")) {
                input.remove(name);
            }
        }

        List<String> attendList = new ArrayList<>(input);
        Collections.sort(attendList, Collections.reverseOrder());
        for (String result : attendList) {
            System.out.println(result);
        }
    }
}
