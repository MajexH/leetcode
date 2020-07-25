package dp;

public class SellDocks {

    public int maxProfit(int[] prices) {
        int minIndex = -1;
        int res = 0;
        int minPriceIndex = -1, maxPriceIndex = -1;
        for (int i = 0; i < prices.length; i++) {
            if (minIndex == - 1 || prices[i] < prices[minIndex]) {
                minIndex = i;
            }
            if (prices[i] - prices[minIndex] > res) {
                minPriceIndex = minIndex;
                maxPriceIndex = i;
                res = prices[i] - prices[minIndex];
            }
        }
        System.out.println(minIndex + " " + minPriceIndex + " " + maxPriceIndex);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SellDocks().maxProfit(new int[]{ 7,4,5,3,6,1 }));
    }
}
