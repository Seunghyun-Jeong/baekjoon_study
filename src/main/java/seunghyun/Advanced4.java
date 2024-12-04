package seunghyun;

import java.util.Scanner;

public class Advanced4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (1 > input.length() || input.length() > 100 || !input.matches("[a-z]+")) {
            throw new IllegalArgumentException();
        }

        StringBuilder reversed = new StringBuilder(input).reverse();
        if (input.equals(reversed.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
