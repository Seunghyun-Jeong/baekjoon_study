package seunghyun;

import java.util.Scanner;

public class DivMulDec2nd4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (3 > N || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = sc.nextInt();
            if (positions[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = positions[i + 1] - positions[i];
        }

        int gcd = distances[0];
        for (int i = 0; i < distances.length; i++) {
            int a = gcd;
            int b = distances[i];
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            gcd = a;
        }

        int result = 0;
        for (int distance : distances) {
            result += (distance / gcd) - 1;
        }
        System.out.println(result);
    }
}
