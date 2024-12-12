package seunghyun;

import java.util.Scanner;

public class Math5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000000) {
            throw new IllegalArgumentException();
        }

        int layer = 1;
        int room = 1;
        while (room < N) {
            room += 6 * layer;
            layer++;
        }
        System.out.println(layer);
    }
}
