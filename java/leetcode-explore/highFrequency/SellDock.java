package highFrequency;

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
}
