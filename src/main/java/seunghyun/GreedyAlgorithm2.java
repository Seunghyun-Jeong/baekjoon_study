package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyAlgorithm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (0 > start || start > end || end > Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int lastEndTime = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEndTime) {
                lastEndTime = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}