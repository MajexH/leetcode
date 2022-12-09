//给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。 
//
// 对于一个整数 y ，如果存在整数 x 满足 y == 3ˣ ，我们称这个整数 y 是三的幂。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：true
//解释：12 = 3¹ + 3²
// 
//
// 示例 2： 
//
// 输入：n = 91
//输出：true
//解释：91 = 3⁰ + 3² + 3⁴
// 
//
// 示例 3： 
//
// 输入：n = 21
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁷ 
// 
//
// Related Topics 数学 👍 93 👎 0


package leetcode.editor.cn;

public class CheckIfNumberIsASumOfPowersOfThree1780 {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree1780().new Solution();
        System.out.println(solution.checkPowersOfThree(12));
        System.out.println(solution.checkPowersOfThree(91));
        System.out.println(solution.checkPowersOfThree(21));
        System.out.println(solution.checkPowersOfThree(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPowersOfThree(int n) {
            // 转换成 3 进制
            while (n != 0) {
                if (n % 3 == 2) {
                    return false;
                }
                n /= 3;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}