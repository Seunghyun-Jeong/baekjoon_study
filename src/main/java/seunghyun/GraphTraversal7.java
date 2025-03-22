package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GraphTraversal7 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (5 > N || N > 25) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> complexSizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            if (line.length() != N) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int complexSize = dfs(i, j, N);
                    complexSizes.add(complexSize);
                }
            }
        }

        System.out.println(complexSizes.size());
        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int x, int y, int N) {
        visited[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && N > nx && N > ny && map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(nx, ny, N);
            }
        }

        return count;
    }
}