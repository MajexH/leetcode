//给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。 
//
// 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] 
//<= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。 
//
// 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。 
//
// 
//
// 示例 1： 
//
// 输入：prices = [8,4,6,2,3]
//输出：[4,2,4,2,3]
//解释：
//商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
//商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
//商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
//商品 3 和 4 都没有折扣。
// 
//
// 示例 2： 
//
// 输入：prices = [1,2,3,4,5]
//输出：[1,2,3,4,5]
//解释：在这个例子中，所有商品都没有折扣。
// 
//
// 示例 3： 
//
// 输入：prices = [10,1,1,6]
//输出：[9,0,1,6]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 500 
// 1 <= prices[i] <= 10^3 
// 
// Related Topics 栈 数组 单调栈 👍 140 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class FinalPricesWithASpecialDiscountInAShop1475 {
    public static void main(String[] args) {
        Solution solution = new FinalPricesWithASpecialDiscountInAShop1475().new Solution();
        System.out.println(Arrays.toString(solution.finalPrices(new int[]{8, 4, 6, 2, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 最开始想的也是右边保存一个最大栈 但实际上这个最大栈是边遍历变更新的
        // 不是先得到最大栈 再去得到结果
        public int[] finalPrices(int[] prices) {
            int[] res = new int[prices.length];
            // 这个地方需要换数据
            Deque<Integer> stack = new LinkedList<>();

            for (int i = prices.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peekLast() > prices[i]) {
                    stack.removeLast();
                }
                res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peekLast();
                stack.addLast(prices[i]);
            }
            return res;
        }

        public int[] finalPricesBruteForce(int[] prices) {
            if (Objects.isNull(prices) || prices.length == 0) {
                return new int[]{};
            }

            int[] res = new int[prices.length];

            for (int i = 0; i < res.length; i++) {
                int deduct = 0;
                for (int j = i + 1; j < res.length; j++) {
                    if (prices[j] <= prices[i]) {
                        deduct = prices[j];
                        break;
                    }
                }
                res[i] = prices[i] - deduct;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}