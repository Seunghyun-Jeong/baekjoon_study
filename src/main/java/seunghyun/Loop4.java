package seunghyun;

import java.util.Scanner;

public class Loop4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        int totalPrice = 0;

        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();
            int count = sc.nextInt();
            int result = price * count;
            totalPrice += result;
        }
        if (X == totalPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
