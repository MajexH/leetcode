//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 163 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class StoneGameIi1140 {
    public static void main(String[] args) {
        Solution solution = new StoneGameIi1140().new Solution();
        System.out.println(solution.stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(solution.stoneGameII(new int[]{1, 2, 3, 4, 5, 100}));
        System.out.println(solution.stoneGameII(new int[]{77, 12, 64, 35, 28, 4, 87, 21, 20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int stoneGameII(int[] piles) {

            int[] reversedSum = new int[piles.length];
            reversedSum[piles.length - 1] = piles[piles.length - 1];

            for (int i = piles.length - 2; i >= 0; i--) {
                reversedSum[i] = reversedSum[i + 1] + piles[i];
            }

            return this.recursion(0, 1, reversedSum, new HashMap<>());
        }

        private int recursion(int i, int m, int[] reversedSum, Map<String, Integer> memo) {

            String key = i + "-" + m;

            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // 能够拿完
            if (i + 2 * m >= reversedSum.length) {
                return reversedSum[i];
            }

            int tmp = Integer.MAX_VALUE;
            // 遍历现在 reversedSum[i] 保存了最大值 那么要现在拿到最大
            // 找到剩下的人拿最小的情况
            for (int j = 1; j <= 2 * m; j++) {
                tmp = Math.min(tmp, this.recursion(i + j, Math.max(j, m), reversedSum, memo));
            }

            memo.put(key, reversedSum[i] - tmp);
            return reversedSum[i] - tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}