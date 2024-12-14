package seunghyun;

import java.util.ArrayList;
import java.util.Scanner;

public class DivMulDec4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        if (!(N > 1 && 1000 > N)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= input; j++) {
                if (input % j == 0) {
                    list.add(j);
                }
            }
            if (list.size() == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
