public class BestTimetoBuyandSellStockIII_123 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        // dp[i][j] 表示 进行 i 次交易 在 j 天的时候 获得的最大收益是多少
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            // i表示在什么时候卖
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                // j表示在什么时候买
                for (int j = 1; j <= i; j++) {
                    // 这个地方为什么要用price[j] - dp[k - 1][j - 1]
                    // 因为其状态转移方程实际上是
                    //  dp[k][i] = Math.max(dp[k][i - 1], prices[i] - prices[j] + dp[k - 1][j - 1]);
                    // prices[i] 就是卖出的价格 后面 就是 在这个卖出价格中的最小值
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockIII_123().maxProfit(new int[]{ 3,3,5,0,0,3,1,4 }));
    }
}
