package seunghyun;

import java.util.Scanner;

public class Backtracking7 {
    private static int N;
    private static int[] numbers;
    private static int[] operators;
    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        backtracking(numbers[0], 1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void backtracking(int result, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                if (i == 0) {
                    backtracking(result + numbers[index], index + 1);
                } else if (i == 1) {
                    backtracking(result - numbers[index], index + 1);
                } else if (i == 2) {
                    backtracking(result * numbers[index], index + 1);
                } else if (i == 3) {
                    backtracking(result / numbers[index], index + 1);
                }
                operators[i]++;
            }
        }
    }
}