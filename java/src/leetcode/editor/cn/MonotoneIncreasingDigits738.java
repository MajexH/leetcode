//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
// Related Topics 贪心 数学 👍 296 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonotoneIncreasingDigits738 {
    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits738().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int monotoneIncreasingDigits(int n) {
            if (n == 0) {
                return 0;
            }
            // 统计每一位数据是什么
            List<Integer> numbers = this.countNumber(n);

            // 找到向下的点
            int preIndex = 0;
            boolean find = false;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(preIndex) > numbers.get(i)) {
                    find = true;
                    break;
                }
                if (numbers.get(preIndex) < numbers.get(i)) {
                    preIndex = i;
                }
            }

            if (!find) {
                return n;
            }
            numbers.set(preIndex, numbers.get(preIndex) - 1);
            for (int i = preIndex + 1; i < numbers.size(); i++) {
                numbers.set(i, 9);
            }

            return this.getNumber(numbers);
        }

        private List<Integer> countNumber(int n) {
            List<Integer> res = new ArrayList<>();
            while (n > 0) {
                res.add(n % 10);
                n /= 10;
            }
            Collections.reverse(res);
            return res;
        }

        private int getNumber(List<Integer> number) {
            int res = 0;
            for (Integer integer : number) {
                res = res * 10 + integer;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}