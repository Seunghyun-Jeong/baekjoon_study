package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackTracking1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (!(M >= 1 && N >= M && 8 >= N)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        int[] seq = new int[M];
        boolean[] visited = new boolean[N];

        generatePermutations(numbers, seq, visited, 0 ,M);
    }

    public static void generatePermutations(List<Integer> numbers, int[] seq, boolean[] visited, int depth, int M) {
        if (depth == M) {
            for (int num : seq) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            seq[depth] = numbers.get(i);
            generatePermutations(numbers, seq, visited, depth + 1, M);
            visited[i] = false;
        }
    }
}