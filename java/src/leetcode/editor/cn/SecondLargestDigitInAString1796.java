//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
//
// Related Topics 哈希表 字符串 👍 46 👎 0


package leetcode.editor.cn;

public class SecondLargestDigitInAString1796 {
    public static void main(String[] args) {
        Solution solution = new SecondLargestDigitInAString1796().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int secondHighest(String s) {
            Integer max = null, secondaryMax = null;

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    continue;
                }

                int num = c - '0';

                if (max == null) {
                    max = num;
                    continue;
                }

                if (max > num) {
                    if (secondaryMax == null || secondaryMax < num) {
                        secondaryMax = num;
                    }
                } else if (max < num) {
                    secondaryMax = max;
                    max = num;
                }


            }

            return secondaryMax == null ? -1 : secondaryMax;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}