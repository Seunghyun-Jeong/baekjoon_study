package seunghyun;

import java.util.Arrays;
import java.util.Scanner;

public class Sort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[5];
        for (int i = 0; i < 5; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += input[i];
        }
        int average = sum / 5;
        System.out.println(average);
        System.out.println(input[2]);
    }
}
