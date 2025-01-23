package seunghyun;

import java.util.Scanner;

public class Recursion5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String result = createCantorSet(n);
            System.out.println(result);
        }
        sc.close();
    }

    public static String createCantorSet(int n) {
        int length = (int) Math.pow(3, n);
        char[] cantorArray = new char[length];
        for (int i = 0; i < length; i++) {
            cantorArray[i] = '-';
        }
        createCantorSetRecursively(cantorArray, 0, length);
        return new String(cantorArray);
    }

    public static void createCantorSetRecursively(char[] cantorArray, int start, int length) {
        if (length == 1) {
            return;
        }
        int partLength = length / 3;
        for (int i = start + partLength; i < start + 2 * partLength; i++) {
            cantorArray[i] = ' ';
        }
        createCantorSetRecursively(cantorArray, start, partLength);
        createCantorSetRecursively(cantorArray, start + 2 * partLength, partLength);
    }
}