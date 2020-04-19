package dp;

public class BuyStocksII {
    public int maxProfit(int[] prices) {
        // 做这个时候 需要完成一次完整的交易
        int res = 0;
        // 因为里面的全部是用 prices[i] prices[i + 1] 来判断 因此 方位到倒数第一位就可
        for (int i = 0; i < prices.length - 1;) {
            int maxPeak = 0, minPeak = 0;
            // 找到 坡底
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            minPeak = prices[i];
            // 找到 坡峰
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            maxPeak = prices[i];
            res += maxPeak - minPeak;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BuyStocksII().maxProfit(new int[]{ 2,2,5 }));
    }
}
