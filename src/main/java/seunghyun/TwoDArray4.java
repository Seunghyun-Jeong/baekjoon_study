package seunghyun;

import java.util.Scanner;

public class TwoDArray4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] paper = new boolean[100][100];
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int row = y; row < y + 10; row++) {
                for (int col = x; col < x + 10; col++) {
                    paper[row][col] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }
        System.out.println(area);
    }
}
