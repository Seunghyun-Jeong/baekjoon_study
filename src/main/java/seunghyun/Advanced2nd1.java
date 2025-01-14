package seunghyun;

import java.util.Scanner;

public class Advanced2nd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if (1 > count || count > 50) {
            throw new IllegalArgumentException();
        }
        int[] div = new int[count];

        for (int i = 0; i < count; i++) {
            div[i] = sc.nextInt();
            if (2 > div[i] || div[i] > 1000000) {
                throw new IllegalArgumentException();
            }
        }

        int minDiv = div[0];
        int maxDiv = div[0];
        for (int i = 1; i < count; i++) {
            if (div[i] < minDiv) {
                minDiv = div[i];
            }
            if (div[i] > maxDiv) {
                maxDiv = div[i];
            }
        }

        int N = minDiv * maxDiv;
        System.out.println(N);
    }
}
