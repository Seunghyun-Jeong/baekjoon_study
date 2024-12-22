package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Sort7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[][] point = new int[N][2];
        for (int i = 0; i < N; i++) {
            point[i][0] = sc.nextInt();
            if (-100000 > point[i][0] || point[i][0] > 100000) {
                throw new IllegalArgumentException();
            }
            point[i][1] = sc.nextInt();
            if (-100000 > point[i][1] || point[i][1] > 100000) {
                throw new IllegalArgumentException();
            }
        }

        Arrays.sort(point, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }
    }
}
