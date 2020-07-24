package chapter2.backtrack;

public class RobotRunningRange {

    public int getNumberSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public int getMNSum(int m, int n) {
        return getNumberSum(m) + getNumberSum(n);
    }

    public int recursion(int x, int y, int m, int n, int k, boolean[][] memo) {
        if (x >= m || x < 0 || y >= n || y < 0 || getMNSum(x, y) > k) return 0;
        memo[x][y] = true;
        // 当前这个点就是1
        int res =  1;
        if (x + 1 < m && !memo[x + 1][y]) res += recursion(x + 1, y, m, n, k, memo);
        if (x - 1 >= 0 && !memo[x - 1][y]) res += recursion(x - 1, y, m, n, k, memo);
        if (y + 1 < n && !memo[x][y + 1]) res += recursion(x, y + 1, m, n, k, memo);
        if (y - 1 >= 0 && !memo[x][y - 1]) res += recursion(x, y - 1, m, n, k, memo);
        return res;
    }

    /**
     * 给定一个 m * n的方格 机器人可以上下左右任意的移动一格
     * 但是不能进入行坐标和列坐标之和大于K的格子
     * 问能够到达多少个格子 机器人从 0, 0 开始运动的话
     * @param m
     * @param n
     * @param k m n 的每位数的和的界限
     * @return
     */
    public int getRobotRunningRange(int m, int n, int k) {
        boolean[][] memo = new boolean[m][n];
        return recursion(0, 0, m, n, k, memo);
    }

    public static void main(String[] args) {
        System.out.println(new RobotRunningRange().getRobotRunningRange(3, 1, 0));
    }
}
