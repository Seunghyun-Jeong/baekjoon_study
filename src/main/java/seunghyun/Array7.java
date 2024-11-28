package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] attendance = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int[] list = new int[28];
        for (int i = 0; i < 28; i++) {
            list[i] = sc.nextInt();
            if (1 > list[i] || list[i] > 30) {
                throw new IllegalArgumentException();
            }
        }
        Arrays.sort(list);

        int index = 0;
        for (int num = 1; num <= 30; num++) {
            if (index < 28 && list[index] == num) {
                index++;
            } else {
                System.out.println(num);
            }
        }
    }
}
