package highFrequency.map;

import java.util.Deque;
import java.util.LinkedList;

public class OrangesRotting {

    public static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // grid 单元格中为2的时候 会在四个方向腐烂橘子
    // 问多久腐烂完 bfs
    public int orangesRotting(int[][] grid) {
        Deque<Pair> rottedOranges = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottedOranges.add(new Pair(i, j));
                }
            }
        }
        int res = 0;
        // 每层的分隔
        rottedOranges.add(null);
        while (!rottedOranges.isEmpty()) {
            // 遍历每个橘子的上下
            Pair first = rottedOranges.removeFirst();
            // 一层结束
            if (first == null) {
                // 所有层结束
                if (rottedOranges.size() == 0) break;
                res++;
                rottedOranges.add(null);
                continue;
            }

            if (first.i + 1 < grid.length && grid[first.i + 1][first.j] == 1) {
                rottedOranges.add(new Pair(first.i + 1, first.j));
                // 用作 memo 表示已经访问过的点
                grid[first.i + 1][first.j] = 2;
            }
            if (first.i - 1 >= 0 && grid[first.i - 1][first.j] == 1) {
                rottedOranges.add(new Pair(first.i - 1, first.j));
                grid[first.i - 1][first.j] = 2;
            }
            if (first.j + 1 < grid[first.i].length && grid[first.i][first.j + 1] == 1) {
                rottedOranges.add(new Pair(first.i, first.j + 1));
                grid[first.i][first.j + 1] = 2;
            }
            if (first.j - 1 >= 0 && grid[first.i][first.j - 1] == 1) {
                rottedOranges.add(new Pair(first.i, first.j - 1));
                grid[first.i][first.j - 1] = 2;
            }
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                // 没有腐烂完
                if (anInt == 1) return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OrangesRotting().orangesRotting(new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));
    }
}
