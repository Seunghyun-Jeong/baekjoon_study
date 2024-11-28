package seunghyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Array8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int A = sc.nextInt();
            set.add(A % 42);
        }
        System.out.println(set.size());
    }
}
