package tencent.dp;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    // 找到获得最大 profit 的一对序列号
    public void getMaxProfitIndex(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.printf("%d %d \n", 0, 0);
            return;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        int minIndexMv = 0, minIndex = 0, maxIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
                minIndexMv = i;
            }
            if (maxProfit < prices[i] - minPrice) {
                minIndex = minIndexMv;
                maxIndex = i;
                maxProfit = prices[i] - minPrice;
            }
        }
        System.out.printf("%d %d \n", minIndex, maxIndex);
    }

    public static void main(String[] args) {
        new MaxProfit().getMaxProfitIndex(new int[]{7,1,5,3,6,4});
    }
}
