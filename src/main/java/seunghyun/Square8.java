package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Square8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sides = new int[3];
        sides[0] = sc.nextInt();
        sides[1] = sc.nextInt();
        sides[2] = sc.nextInt();
        if (1 > sides[0] || sides[0] > 100 || 1 > sides[1] || sides[1] > 100 || 1 > sides[2] || sides[2] > 100) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(sides);

        if (sides[2] >= sides[0] + sides[1]) {
            sides[2] = sides[0] + sides[1] -1;
        }
        int result = sides[0] + sides[1] + sides[2];
        System.out.println(result);
    }
}
