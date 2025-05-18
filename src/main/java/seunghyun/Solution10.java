package seunghyun;

import java.util.Scanner;

public class Solution10 {
    private static int[][] map;
    private static int num = 0;

    private static boolean check(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[i - 1][j - 1] != 0)
                    return false;
            }
        }
        return true;
    }

    private static void tromino(int s, int x, int y) {
        if (s == 0)
            return;
        int size = 1 << (s - 1);
        num++;
        if (check(x, y, x + size, y + size))
            map[x + size - 2][y + size - 2] = num;
        if (check(x + size, y, x + 2 * size, y + size))
            map[x + size - 1][y + size - 2] = num;
        if (check(x, y + size, x + size, y + 2 * size))
            map[x + size - 2][y + size - 1] = num;
        if (check(x + size, y + size, x + 2 * size, y + 2 * size))
            map[x + size - 1][y + size - 1] = num;

        // 네 구역에 대해 재귀 호출
        tromino(s - 1, x, y);
        tromino(s - 1, x + size, y);
        tromino(s - 1, x, y + size);
        tromino(s - 1, x + size, y + size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int siz = 1 << k;
        map = new int[siz][siz];
        map[m - 1][n - 1] = -1;

        tromino(k, 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = siz - 1; i >= 0; i--) {
            for (int j = 0; j < siz; j++) {
                sb.append(map[j][i]);
                if (j != siz - 1)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}