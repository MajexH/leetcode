package microsoft;

public class Domino {
    private static int res = 0, max = 0;

    // 给定一个长度 n 宽为 m 的棋盘 其中 broken 表示坏掉不能用的格子
    // 问如果用 2 * 1 的方格去填充他 最多能有多少个 方格能被填充
    // 坏的格子不能填充
    public int domino(int n, int m, int[][] broken) {
        res = 0;
        max = 0;
        boolean[][] map = new boolean[n][m];
        for (int[] node : broken) {
            // 已经摆放过了
            map[node[0]][node[1]] = true;
        }
        dfs(map, 0, 0);
        return max;
    }

    // 首先保证第一个输入的 i j 不会越界
    public void dfs(boolean[][] map, int i, int j) {
        if (i >= map.length) {
            // 比较保存的结果
            max = Math.max(res, max);
            return;
        }
        if (j >= map[i].length) {
            // 跳到下一行
            dfs(map, i + 1, 0);
            return;
        }
        // 已经摆放过了 或者 不能用这个点
        if (map[i][j]) {
            dfs(map, i, j + 1);
            return;
        }
        boolean pass = true;
        map[i][j] = true;
        // 分别尝试 横着摆放 和 竖着摆放
        if (i + 1 < map.length && !map[i + 1][j]) {
            // 竖着摆放 跳过一个即可
            map[i + 1][j] = true;
            res++;
            dfs(map, i, j + 1);
            res--;
            map[i + 1][j] = false;
            pass = false;
        }
        if (j + 1 < map[i].length && !map[i][j + 1]) {
            // 横着摆放 跳过两个
            map[i][j + 1] = true;
            res++;
            dfs(map, i, j + 2);
            res--;
            map[i][j + 1] = false;
            pass = false;
        }
        map[i][j] = false;
        if (pass)
            // 甚至还可以跳过这个点不放
            dfs(map, i, j + 1);
    }

    public static void main(String[] args) {
        //System.out.println(new Domino().domino(2, 3, new int[][]{{1,0},{1,1}}));
        //System.out.println(new Domino().domino(3, 3, new int[][]{}));
        System.out.println(new Domino().domino(3, 2, new int[][]{{1, 1}, {2, 1}}));
    }
}
