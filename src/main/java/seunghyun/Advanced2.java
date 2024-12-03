package seunghyun;

import java.util.Scanner;

public class Advanced2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] chess = {1, 1, 2, 2, 2, 8};

        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = sc.nextInt();
        }

        int[] result = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            result[i] = chess[i] - input[i];
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
