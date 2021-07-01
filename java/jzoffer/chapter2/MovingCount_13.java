package chapter2;

public class MovingCount_13 {

    private int res = 0;

    private int getSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }


    public int movingCount(int m, int n, int k) {
        res = 0;
        boolean[][] memo = new boolean[m][n];
        recursion(0, 0, m, n, k, memo);

        return res;
    }

    public void recursion(int i, int j, int m, int n, int k, boolean[][] memo) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }
        if (getSum(i) + getSum(j) > k) {
            return;
        }
        if (memo[i][j]) return;
        memo[i][j] = true;
        res++;
        recursion(i + 1, j, m, n, k, memo);
        recursion(i - 1, j, m, n, k, memo);
        recursion(i, j + 1, m, n, k, memo);
        recursion(i, j - 1, m, n, k, memo);
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount_13().movingCount(2, 3, 1));
    }
}
