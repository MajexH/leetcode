package meituan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Move {

    public static class Pair {
        int a;
        int b;

        public Pair(int a) {
            this.a = a;
        }

        // 复用一哈
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int[][] directions(int t, int a, int b) {
        int tmp = t % (a + b) - a;
        if (tmp < 0) {
            return new int[][]{{-1, 0}, {1, 0}};
        }
        return new int[][]{{0, 1}, {0, -1}};
    }

    private static int minTime = Integer.MAX_VALUE;

    // 有折返 dfs 做不了 因为可能这个点不走 所以 dfs 会无线递归
    // 只能用 bfs 做
    private static void dfs(int i, int j, Pair[][] map, int time, int xT, int yT, boolean[][] memo) {
        if (i == xT && j == yT) {
            minTime = Math.min(minTime, time);
            return;
        }
        memo[i][j] = true;
        int[][] directions = directions(time, map[i][j].a, map[i][j].b);
        for (int[] direction : directions) {
            int newI = i + direction[0], newJ = j + direction[1];
            if (newI < 0 || newI >= map.length || newJ < 0 || newJ >= map[i].length) {
                continue;
            }
            if (!memo[newI][newJ]) dfs(newI, newJ, map, time + 1, xT, yT, memo);
        }
        // 或者 还有中可能是不走
        dfs(i, j, map, time + 1, xT, yT, memo);
        memo[i][j] = false;
    }

    private static int bfs(int i, int j, Pair[][] map, int xT, int yT, boolean[][] memo) {
        int time = 0;
        Deque<Pair> queue = new LinkedList<>();
        memo[i][j] = true;
        queue.addLast(new Pair(i, j));
        queue.addLast(null);
        while (queue.size() > 0) {
            Pair first = queue.removeFirst();
            if (first == null) {
                if (queue.size() == 0) break;
                time++;
                queue.add(null);
                continue;
            }

            if (first.a == xT && first.b == yT) {
                return time;
            }

            int[][] directions = directions(time, map[i][j].a, map[i][j].b);
            for (int[] direction : directions) {
                int newI = first.a + direction[0], newJ = first.b + direction[1];
                if (newI < 0 || newI >= map.length || newJ < 0 || newJ >= map[i].length) {
                    continue;
                }
                if (!memo[newI][newJ]) {
                    memo[newI][newJ] = true;
                    queue.addLast(new Pair(newI, newJ));
                }
            }
            // 可能不走
            queue.addLast(first);
            memo[first.a][first.b] = true;
        }

        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int xS = sc.nextInt(), yS = sc.nextInt();
        int xT = sc.nextInt(), yT = sc.nextInt();


        Pair[][] map = new Pair[n][m];
        boolean[][] memo = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = new Pair(sc.nextInt());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j].b = sc.nextInt();
            }
        }
        System.out.println(bfs(xS - 1, yS - 1, map, xT - 1, yT - 1, memo));
    }
}
