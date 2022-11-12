//有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
//
// 
//
// 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。 
//
// 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 3
//输出: 5
//解释: 五种不同的方法如上所示。
// 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 动态规划 👍 210 👎 0


package leetcode.editor.cn;

public class DominoAndTrominoTiling790 {
    public static void main(String[] args) {
        Solution solution = new DominoAndTrominoTiling790().new Solution();
        System.out.println(solution.numTilings(3)); // 5
        System.out.println(solution.numTilings(4)); // 11
        System.out.println(solution.numTilings(5)); // 24
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) (1e9 + 7);

        public int numTilings(int n) {

            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }
            // 可以分为两种情况
            // 1 是完全填满
            // 2 是缺少一个角
            // 因为完全填满的话 可以用上上个缺少一角的补起来
            long[] dp = new long[n + 1];
            long[] missing = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            // 可以直接用两个 L 型 脾气来
            missing[2] = 2;

            for (int i = 3; i <= n; i++) {
                // 可以用上一个已经填满的 + 填补两块的 + 上一个缺失一角的
                dp[i] = (dp[i - 1] + dp[i - 2] + missing[i - 1]) % MOD;
                // 可以用两个之前填满的 加上两个 L 组成 or 直接用上一个的 组成
                missing[i] = (dp[i - 2] * 2 + missing[i - 1]) % MOD;
            }

            return (int) (dp[n] % MOD);
        }


        public int numTilingsWithMath(int n) {

            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
            }

            return (int) (dp[n] % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}