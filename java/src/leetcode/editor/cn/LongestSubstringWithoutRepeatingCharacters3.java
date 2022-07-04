package leetcode.editor.cn;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7751 👎 0


import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters3().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int curLength = 0;
            int[] preIndexes = new int[255];

            Arrays.fill(preIndexes, -1);

            for (int i = 0; i < s.length(); i++) {
                int preIndex = preIndexes[s.charAt(i)];

                // 那么这个时候 preIndex - i 之间还是没有重复的
                if (preIndex == -1 || curLength < i - preIndex) {
                    curLength++;
                } else {
                    // 说明这个时候前面已经有重复的了
                    curLength = i - preIndex;
                }
                preIndexes[s.charAt(i)] = i;
                maxLength = Math.max(maxLength, curLength);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}