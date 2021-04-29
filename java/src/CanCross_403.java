public class CanCross_403 {

    public boolean canCross(int[] stones) {
        // 可以一步一步的向右跳跳 每次跳的距离只能是 k - 1 k k + 1 其中 k 是上一次跳的距离
        // 给定的 stones 数组是 stone 的下标 表示在某个位置有个 stone
        // 第一步 一定只能从 1 到 2

        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 两个相差的距离 这个距离就是 j 转移到 i 的距离
                int k = stones[i] - stones[j];
                // 最大的结果就是 j + 1 相当于直接从 0 跳转到 j 的长度
                if (k > j + 1) break;
                // dp[j][k - 1] 这些表示 能够到达 j 以什么样的长度 所以 只要 能够到达任意一个的 就算到达了 j 这个点
                dp[i][k] = dp[j][k - 1] || dp[j][k + 1] || dp[j][k];
                if (dp[i][k] && i == n - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanCross_403().canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
