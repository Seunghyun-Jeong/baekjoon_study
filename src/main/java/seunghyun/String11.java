package seunghyun;

import java.util.Scanner;

public class String11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            System.out.println(input);
            if (input.equals("")) {
                break;
            }
        }
        sc.close();
    }
}
