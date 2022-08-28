//f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
//
// 
// 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。 
// 
//
// 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 0
//输出：5
//解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
// 
//
// 示例 2： 
//
// 
//输入：k = 5
//输出：0
//解释：没有匹配到这样的 x!，符合 k = 5 的条件。 
//
// 示例 3: 
//
// 
//输入: k = 3
//输出: 5
// 
//
// 
//
// 提示: 
//
// 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 数学 二分查找 👍 156 👎 0


package leetcode.editor.cn;

public class PreimageSizeOfFactorialZeroesFunction793 {
    public static void main(String[] args) {
        Solution solution = new PreimageSizeOfFactorialZeroesFunction793().new Solution();
        System.out.println(solution.preimageSizeFZF(92));
        System.out.println(solution.preimageSizeFZF(0));
        System.out.println(solution.preimageSizeFZF(5));
        System.out.println(solution.preimageSizeFZF(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 可以用二分来做 如果
        public int preimageSizeFZF(int k) {
            return this.binarySearch(0, 5 * (k + 1), k + 1) - this.binarySearch(0, 5 * k, k);
        }

        private int binarySearch(int left, int right, int k) {

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int tailingZero = this.getTailingZero(mid);

                if (tailingZero >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right + 1;
        }

        // num! 有多少个后缀0
        private int getTailingZero(int num) {
            int res = 0;
            while (num > 0) {
                num /= 5;
                res += num;
            }
            return res;
        }

        // 超时 如果数字太大
        // 思路就是直接累加当前有多少个 0 看数据是否达到了要求的 k 个 0 的上限
        public int preimageSizeFZFTimeout(int k) {
            if (k == 0) {
                return 5;
            }
            // 计算有多少个 5
            int counterOfFive = 0;
            // k 个 0 后缀 那么就意味有 k 个 5
            int maxNumber = 0, pre = 0;
            for (; counterOfFive < k; maxNumber += 5) {
                pre = maxNumber;
                counterOfFive += this.contains5(maxNumber);
            }
            if (counterOfFive != k) {
                return 0;
            }
            return maxNumber - pre;
        }

        private int contains5(int num) {
            int res = 0;
            if (num == 0) {
                return res;
            }
            while (num % 5 == 0) {
                num /= 5;
                res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}