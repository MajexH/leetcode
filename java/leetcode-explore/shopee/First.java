package shopee;

import java.util.Scanner;

public class First {

    // 三个方向
    private static int[][] directions = new int[][]{{0, -1}, {0, 1}};

    private static int travel(boolean[][] isBlack) {
        int res = Integer.MAX_VALUE;
        // 遍历起点
        for (int i = 0; i < isBlack[0].length; i++) {
            res = Math.min(res, dfs(makeCopy(isBlack), 0, i, 0));
        }
        return res;
    }

    private static boolean[][] makeCopy(boolean[][] isBlack) {
        boolean[][] res = new boolean[isBlack.length][isBlack[0].length];
        for (int i = 0; i < isBlack.length; i++) {
            System.arraycopy(isBlack[i], 0, res[i], 0, isBlack[i].length);
        }
        return res;
    }

    // 回溯路径无效的
    private static int dfs(boolean[][] isBlack, int i, int j, int counter) {
        if (i >= isBlack.length) return counter;
        if (i == isBlack.length - 1 && !travelLayer(isBlack, i, 0, isBlack[i].length - 1)) {
            return counter;
        }
        // 黑色块
        isBlack[i][j] = false;

        int res = Integer.MAX_VALUE;
        boolean goDown = true;
        // 向左走
        if (j - 1 >= 0) {
            if (travelLayer(isBlack, i, 0, j - 1)) {
                goDown = false;
                res = Math.min(res, dfs(isBlack, i, j - 1, counter + 1));
            }
        }
        // 向右走
        if (j + 1 < isBlack[i].length) {
            if (travelLayer(isBlack, i, j + 1, isBlack[i].length - 1)) {
                goDown = false;
                res = Math.min(res, dfs(isBlack, i, j + 1, counter + 1));
            }
        }
        if (goDown) {
            res = Math.min(res, dfs(isBlack, i + 1, j, counter + 1));
        }
        return res;
    }

    private static boolean travelLayer(boolean[][] isBlack, int i, int start, int end) {
        boolean flag = false;
        for (int index = start; index <= end; index++) {
            flag = flag || isBlack[i][index];
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean[][] isBlack = new boolean[n][m];
            for (int j = 0; j < n; j++) {
                // 表示每行有几个黑色的格子
                int k = sc.nextInt();
                for (int z = 0; z < k; z++) {
                    isBlack[j][sc.nextInt() - 1] = true;
                }
            }
            // 输出遍历完所有的黑色格子的最短路径
            System.out.println(travel(isBlack));
        }
    }
}
