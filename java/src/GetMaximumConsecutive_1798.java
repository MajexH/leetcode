import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GetMaximumConsecutive_1798 {

    // 给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i]。如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以
    // 构造出 x 。
    //
    //请返回从 0 开始（包括 0 ），你最多能构造出多少个连续整数。
    //
    //你可能有多个相同值的硬币。
    public int getMaximumConsecutive(int[] coins) {
        // 至少包含 0
        if (coins == null || coins.length == 0) return 1;
        // 考虑从 1 开始构建
        // res 保存能够形成的最大连续数值
        int res = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            // 如果排序后的值 已经超过了res + 1 的位置
            // 说明加上这个数后， [0, res] 与 [coin, coin + res] 不再连续
            if (coin > res + 1) break;
            // 否则相当于现在的最大的连续数值 到了 coin + res 的地方
            res += coin;
        }
        // 加上 0
        return res + 1;
    }
}
