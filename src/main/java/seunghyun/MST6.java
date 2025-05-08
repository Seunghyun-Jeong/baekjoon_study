package seunghyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MST6 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int islandCount = 0;

    private static class Bridge implements Comparable<Bridge> {
        int from, to, length;

        Bridge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }

        public int compareTo(Bridge o) {
            return this.length - o.length;
        }
    }

    private static List<Bridge> bridges = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        if (1 > N || N > 10 || 1 > M || M > 10) {
            throw new IllegalArgumentException();
        }
        if (3 > N * M || N * M > 100) {
            throw new IllegalArgumentException();
        }

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        labelIslands();

        if (2 > islandCount || islandCount > 6) {
            throw new IllegalArgumentException();
        }

        findAllBridges();

        int result = kruskal();

        System.out.println(result);
    }

    private static void labelIslands() {
        int label = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, label++);
                }
            }
        }
        islandCount = label - 2;
    }

    private static void bfs(int x, int y, int label) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        map[x][y] = label;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (isInBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = label;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void findAllBridges() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] >= 2) {
                    int from = map[x][y];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        int len = 0;

                        while (isInBounds(nx, ny)) {
                            if (map[nx][ny] == from) break;
                            if (map[nx][ny] == 0) {
                                len++;
                                nx += dx[d];
                                ny += dy[d];
                            } else {
                                if (len >= 2) {
                                    int to = map[nx][ny];
                                    bridges.add(new Bridge(from - 2, to - 2, len));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int kruskal() {
        Collections.sort(bridges);
        parent = new int[islandCount];
        for (int i = 0; i < islandCount; i++) parent[i] = i;

        int total = 0, used = 0;
        for (Bridge b : bridges) {
            if (union(b.from, b.to)) {
                total += b.length;
                used++;
            }
        }

        return used == islandCount - 1 ? total : -1;
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}