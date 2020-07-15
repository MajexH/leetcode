package highFrequency.classic;

public class SellDock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(price - min, maxProfit);
        }
        return maxProfit;
    }

    // 这个找到取最大最小值的一个下标
    public void maxProfitPrintIndex(int[] prices) {
        if (prices == null || prices.length == 0) return;
        int minIndex = -1;
        int resMinIndex = -1, resMaxIndex = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minIndex == -1 || prices[minIndex] > prices[i]) {
                minIndex = i;
            }
            if (prices[i] - prices[minIndex] > maxSum) {
                // 更新最大值
                maxSum = prices[i] - prices[minIndex];
                resMaxIndex = i;
                resMinIndex = minIndex;
            }
        }
        System.out.format("%d,%d", resMinIndex, resMaxIndex);
    }

    public static void main(String[] args) {
        new SellDock().maxProfitPrintIndex(new int[]{ 7,6,4,3,1 });
    }
}
