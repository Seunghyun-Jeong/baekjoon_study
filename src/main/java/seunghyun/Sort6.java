package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Sort6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        if (1 > Integer.parseInt(N) || Integer.parseInt(N) > 1000000000) {
            throw new IllegalArgumentException();
        }

        char[] result = N.toCharArray();
        Arrays.sort(result);
        for (int i = result.length - 1; i >= 0 ; i--) {
            System.out.print(result[i]);
        }
    }
}
