package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DPAndSP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[N];
        int[] preIndex = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (-1000000000 > arr[i] || arr[i] > 1000000000) {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            if (key > list.get(list.size() - 1)) {
                list.add(key);
                preIndex[i] = list.size() - 1;
            } else {
                int low = 0;
                int high = list.size() - 1;
                while (high > low) {
                    int mid = (low + high) / 2;
                    if (list.get(mid) >= key) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                list.set(high, key);
                preIndex[i] = high;
            }
        }

        System.out.println(list.size());
        Stack<Integer> stack = new Stack<>();
        int index = list.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (preIndex[i] == index) {
                index--;
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}