package seunghyun;

import java.util.Scanner;

public class TwoDArray3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[5];
        for (int i = 0; i < 5; i++) {
            input[i] = sc.nextLine();
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < input[j].length()) {
                    result.append(input[j].charAt(i));
                }
            }
        }
        System.out.println(result.toString());
    }
}
