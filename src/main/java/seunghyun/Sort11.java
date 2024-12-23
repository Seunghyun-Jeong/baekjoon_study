package seunghyun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sort11 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (1 > N || N > 1000000) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>();
        int[] input = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(split[i]);
            if (-1000000000 > x || x > 1000000000) {
                throw new IllegalArgumentException();
            }
            input[i] = x;
            set.add(x);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(input[i]) + " ");
        }
        bw.flush();
    }
}
