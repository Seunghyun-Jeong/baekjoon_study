package seunghyun;

import java.util.Scanner;

public class Advanced6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.length() > 100 || !input.matches("[a-z=-]+")) {
            throw new IllegalArgumentException();
        }

        input = input.replace("dz=", "0");
        input = input.replace("c=", "0");
        input = input.replace("c-", "0");
        input = input.replace("d-", "0");
        input = input.replace("lj", "0");
        input = input.replace("nj", "0");
        input = input.replace("s=", "0");
        input = input.replace("z=", "0");
        System.out.println(input.length());
    }
}
