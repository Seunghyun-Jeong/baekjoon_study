package seunghyun;

import java.util.Scanner;

public class Recursion6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] pattern = new char[N][N];
        fillPattern(pattern, 0, 0, N);
        printPattern(pattern);
    }

    public static void fillPattern(char[][] pattern, int x, int y, int size) {
        if (size == 1) {
            pattern[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    fillBlank(pattern, x + newSize, y + newSize, newSize);
                } else {
                    fillPattern(pattern, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    public static void fillBlank(char[][] pattern, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                pattern[i][j] = ' ';
            }
        }
    }

    public static void printPattern(char[][] pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                sb.append(pattern[i][j] == '*' ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}