//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 148 👎 0


package leetcode.editor.cn;

public class GetKthMagicNumberLcci_17_09 {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci_17_09().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final class Factor {
            int factor;
            int index;
        }

        // 能够同时被 357 整除的数儿 其实就是丑数
        public int getKthMagicNumber(int k) {
            if (k == 1) {
                return 1;
            }

            int[] nums = new int[k];
            nums[1] = 1;

            Factor[] indexes = new Factor[3];

            for (int i = 1; i <= k; i++) {
                int min = 0;



            }

            return nums[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}