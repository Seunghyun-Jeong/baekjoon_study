package seunghyun;

import java.util.Scanner;

public class Array10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }

        float sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (float) list[i] / max * 100;
        }

        float average = sum / N;
        System.out.println(average);
    }
}
