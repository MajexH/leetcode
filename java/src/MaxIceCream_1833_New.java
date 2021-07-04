import java.util.Arrays;

public class MaxIceCream_1833_New {

    // 贪心 肯定是买最便宜的最好
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            coins -= cost;
            res++;
        }
        return res;
    }

    // 01 背包问题 dp 超时
    public int maxIceCreamUsingDP(int[] costs, int coins) {
        int[] dp = new int[coins + 1];
        Arrays.sort(costs);
        for (int cost : costs) {
            for (int i = coins; i >= 1; i--) {
                if (i >= cost) {
                    dp[i] = Math.max(dp[i], dp[i - cost] + 1);
                    continue;
                }
                break;
            }
        }

        return dp[coins];
    }

    public static void main(String[] args) {
        System.out.println(new MaxIceCream_1833_New().maxIceCream(new int[]{1,3,2,4,1}, 7));
        System.out.println(new MaxIceCream_1833_New().maxIceCream(new int[]{10,6,8,7,7,8}, 5));
        System.out.println(new MaxIceCream_1833_New().maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }
}
