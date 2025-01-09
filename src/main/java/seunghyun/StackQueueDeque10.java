package seunghyun;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StackQueueDeque10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000) {
            throw new IllegalArgumentException();
        }

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        while (!list.isEmpty()) {
            int crrentInput = list.remove(index);
            System.out.print(crrentInput);
            if (!list.isEmpty()) {
                System.out.print(" ");
            }
            if (list.isEmpty()) {
                break;
            }

            int move = input[crrentInput - 1];
            if (move > 0) {
                move--;
            }
            index = (index + move) % list.size();
            if (index < 0) {
                index += list.size();
            }
        }
    }
}
