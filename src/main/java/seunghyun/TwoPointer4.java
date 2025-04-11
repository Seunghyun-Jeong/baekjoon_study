package seunghyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwoPointer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 1 || N > 4000000) {
            throw new IllegalArgumentException();
        }

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int left = 0, right = 0, sum = 0, count = 0;
        while (right < primes.size() || sum >= N) {
            if (sum < N && right < primes.size()) {
                sum += primes.get(right++);
            } else {
                if (sum == N) {
                    count++;
                }
                sum -= primes.get(left++);
            }
        }
        System.out.println(count);
    }
}