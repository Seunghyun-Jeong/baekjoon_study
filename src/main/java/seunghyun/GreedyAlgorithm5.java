package seunghyun;

import java.util.Scanner;

public class GreedyAlgorithm5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (2 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        long[] roadLength = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            roadLength[i] = sc.nextLong();
            if (1 > roadLength[i] || roadLength[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        long[] fuelPrice = new long[N];
        for (int i = 0; i < N; i++) {
            fuelPrice[i] = sc.nextLong();
            if (1 > fuelPrice[i] || fuelPrice[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        long totalCost = 0;
        long minPrice = fuelPrice[0];
        for (int i = 0; i < N - 1; i++) {
            if (minPrice > fuelPrice[i]) {
                minPrice = fuelPrice[i];
            }
            totalCost += minPrice * roadLength[i];
        }

        System.out.println(totalCost);
    }
}