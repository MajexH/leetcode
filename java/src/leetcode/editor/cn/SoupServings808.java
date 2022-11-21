//有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
//
// 
// 提供 100ml 的 汤A 和 0ml 的 汤B 。 
// 提供 75ml 的 汤A 和 25ml 的 汤B 。 
// 提供 50ml 的 汤A 和 50ml 的 汤B 。 
// 提供 25ml 的 汤A 和 75ml 的 汤B 。 
// 
//
// 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。
//当两种类型的汤都分配完时，停止操作。 
//
// 注意 不存在先分配 100 ml 汤B 的操作。 
//
// 需要返回的值： 汤A 先分配完的概率 + 汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10⁻⁵ 的范围内将被认为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 50
//输出: 0.62500
//解释:如果我们选择前两个操作，A 首先将变为空。
//对于第三个操作，A 和 B 会同时变为空。
//对于第四个操作，B 首先将变为空。
//所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
// 
//
// 示例 2: 
//
// 
//输入: n = 100
//输出: 0.71875
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 数学 动态规划 概率与统计 👍 185 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SoupServings808 {
    public static void main(String[] args) {
        Solution solution = new SoupServings808().new Solution();
        System.out.println(solution.soupServings(5000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double soupServings(int n) {
            // n == 5000 prob = 0.9999967386599964 误差已经小于 10^-5
            if (n >= 5000) {
                return 1;
            }

            Map<String, Double> memo = new HashMap<>();
            return this.recursion(n, n, memo);
        }

        private double recursion(int a, int b, Map<String, Double> memo) {

            // 汤A 先分配完的概率 分为 1 2 两种
            if (a == 0 && b != 0) {
                return 1;
            }

            // 汤A和汤B 同时分配完的概率 / 2
            if (a == 0 && b == 0) {
                return 0.5D;
            }

            if (a != 0 && b == 0) {
                return 0;
            }

            String key = String.format("%d_%d", a, b);

            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            double prob = 0;
            prob += this.recursion(Math.max(0, a - 100), b, memo);             // 操作 1
            prob += this.recursion(Math.max(0, a - 75), Math.max(0, b - 25), memo); // 操作 2
            prob += this.recursion(Math.max(0, a - 50), Math.max(0, b - 50), memo); // 操作 3
            prob += this.recursion(Math.max(0, a - 25), Math.max(0, b - 75), memo); // 操作 4

            prob *= 0.25;

            memo.put(key, prob);

            return prob;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}