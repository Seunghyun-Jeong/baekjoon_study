package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Advanced2nd4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 500000 || N % 2 == 0) {
            throw new IllegalArgumentException();
        }
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
            if (Math.abs(input[i]) > 4000) {
                throw new IllegalArgumentException();
            }
        }

        double sum = 0;
        for (int num : input) {
            sum += num;
        }
        int mean = (int) Math.round(sum / N);

        Arrays.sort(input);
        int median = input[N / 2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : input) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int mode = list.get(0).getKey();
        if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            List<Integer> modes = new ArrayList<>();
            int result = list.get(0).getValue();
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == result) {
                    modes.add(entry.getKey());
                } else {
                    break;
                }
            }
            Collections.sort(modes);
            mode = modes.get(1);
        }

        int range = input[N - 1] - input[0];
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
