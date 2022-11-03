//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
//
// Related Topics 字符串 字符串匹配 👍 94 👎 0


package leetcode.editor.cn;

public class MaximumRepeatingSubstring1668 {
    public static void main(String[] args) {
        Solution solution = new MaximumRepeatingSubstring1668().new Solution();
        System.out.println(solution.maxRepeating("ababc", "ab"));
        System.out.println(solution.maxRepeating("ababc", "ba"));
        System.out.println(solution.maxRepeating("ababc", "ac"));
        System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxRepeating(String sequence, String word) {

            int res = 0;

            for (int i = 0; i < sequence.length(); i++) {
                if (sequence.charAt(i) != word.charAt(0)) {
                    continue;
                }
                int j = i;
                // 如果第一个字段相等 那么可以开始匹配
                int counter = 0;
                // 没匹配一次向上增加
                while (pattern(sequence, j, word)) {
                    counter++;
                    j += word.length();
                }
                res = Math.max(res, counter);
            }

            return res;

        }

        private boolean pattern(String sequence, int i, String word) {
            int j = 0;
            for (; j < word.length() && i < sequence.length(); j++, i++) {
                if (sequence.charAt(i) != word.charAt(j)) {
                    return false;
                }
            }

            return j == word.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}