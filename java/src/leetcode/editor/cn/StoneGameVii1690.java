//石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。 
//
// 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得
//分较高者获胜。 
//
// 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。 
//
// 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分
//的差值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [5,3,1,4,2]
//输出：6
//解释：
//- 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
//- 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
//- 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
//- 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
//- 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
//得分的差值 18 - 12 = 6 。
// 
//
// 示例 2： 
//
// 
//输入：stones = [7,90,5,1,100,10,10,2]
//输出：122 
//
// 
//
// 提示： 
//
// 
// n == stones.length 
// 2 <= n <= 1000 
// 1 <= stones[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 67 👎 0


package leetcode.editor.cn;

public class StoneGameVii1690 {
    public static void main(String[] args) {
        Solution solution = new StoneGameVii1690().new Solution();
        System.out.println(solution.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int stoneGameVII(int[] stones) {
            int[][] sum = new int[stones.length][stones.length];

            for (int i = 0; i < stones.length; i++) {
                sum[i][i] = stones[i];
                for (int j = i + 1; j < stones.length; j++) {
                    sum[i][j] = stones[j] + sum[i][j - 1];
                }
            }

            // 记录每一步能够拿到的最大的差值
            int[][] dp = new int[stones.length][stones.length];

            // 从后往前遍历 才能先求解子问题
            for (int i = stones.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < stones.length; j++) {
                    // 分别取左右两边 拿到最大值
                    dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
                }
            }

            return dp[0][stones.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}