//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aa"
//输出：0
//解释：最优的子字符串是两个 'a' 之间的空子字符串。 
//
// 示例 2： 
//
// 输入：s = "abca"
//输出：2
//解释：最优的子字符串是 "bc" 。
// 
//
// 示例 3： 
//
// 输入：s = "cbzxy"
//输出：-1
//解释：s 中不存在出现出现两次的字符，所以返回 -1 。
// 
//
// 示例 4： 
//
// 输入：s = "cabbac"
//输出：4
//解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// s 只含小写英文字母 
// 
//
// Related Topics 哈希表 字符串 👍 64 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class LargestSubstringBetweenTwoEqualCharacters1624 {
    public static void main(String[] args) {
        Solution solution = new LargestSubstringBetweenTwoEqualCharacters1624().new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cbzxy"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {

            if (Objects.isNull(s) || s.length() == 0) {
                return 0;
            }

            int[] pres = new int[26];
            Arrays.fill(pres, -1);
            int res = -1;

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (pres[index] == -1) {
                    pres[index] = i;
                    continue;
                }
                res = Math.max(res, i - pres[index] - 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}