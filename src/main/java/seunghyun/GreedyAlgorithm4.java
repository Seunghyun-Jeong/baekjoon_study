package seunghyun;

import java.util.Scanner;

public class GreedyAlgorithm4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.length() > 50) {
            throw new IllegalArgumentException();
        }

        String[] parts = input.split("-");
        int result = 0;

        String[] firPart = parts[0].split("\\+");
        for (String num : firPart) {
            result += Integer.parseInt(num);
        }

        for (int i = 1; i < parts.length; i++) {
            String[] nums = parts[i].split("\\+");
            for (String num : nums) {
                result -= Integer.parseInt(num);
            }
        }

        System.out.println(result);
    }
}