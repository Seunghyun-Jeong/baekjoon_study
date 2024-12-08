package seunghyun;

import java.util.Scanner;

public class TwoDArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] input = new int[9][9];

        int max = -1;
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                input[i][j] = sc.nextInt();
                if (input[i][j] > 100 || 0 > input[i][j]) {
                    throw new IllegalArgumentException();
                }
                if (input[i][j] > max) {
                    max = input[i][j];
                    row = i+1;
                    column = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
