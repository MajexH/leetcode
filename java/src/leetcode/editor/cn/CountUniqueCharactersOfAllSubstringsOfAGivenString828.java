//我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。 
//
// 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 
//countUniqueChars(s) = 5 。 
//
// 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整
//数。 
//
// 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "ABC"
//输出: 10
//解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
//     其中，每一个子串都由独特字符构成。
//     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
// 
//
// 示例 2： 
//
// 
//输入: s = "ABA"
//输出: 8
//解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
// 
//
// 示例 3： 
//
// 
//输入：s = "LEETCODE"
//输出：92
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只包含大写英文字符 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 157 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString828 {
    public static void main(String[] args) {
        Solution solution = new CountUniqueCharactersOfAllSubstringsOfAGivenString828().new Solution();
//        System.out.println(solution.uniqueLetterString("AAXAA"));
//        System.out.println(solution.uniqueLetterString("ABA"));
        System.out.println(solution.uniqueLetterString("ABC"));
        System.out.println(solution.uniqueLetterString("LEETCODE"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 计算的是当前这个字符对最后结果的贡献度
        // 当前这个字符如果在中间 那么其左右的字符串
        public int uniqueLetterString(String s) {
            List<Integer>[] dp = new List[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int position = c - 'A';

                if (dp[position] == null) {
                    dp[position] = new ArrayList<>(Arrays.asList(-1));
                }
                dp[position].add(i);
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == null) {
                    continue;
                }
                // 添加 n 的数据
                dp[i].add(s.length());
                for (int j = 1; j < dp[i].size() - 1; j++) {
                    res += (dp[i].get(j) - dp[i].get(j - 1)) * (dp[i].get(j + 1) - dp[i].get(j));
                }

            }
            return res;
        }

        // 暴力解法 想到的是一个字符一个字符的往后推进 通过上一个状态记录的是否有重复的字符来保证结果
        public int uniqueLetterStringBruteForce(String s) {
            int res = 0;

            Pair[] bits = new Pair[s.length()];
            for (int i = 0; i < s.length(); i++) {
                bits[i] = new Pair();
            }
            int[] dp = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int position = c - 'A';
                for (int j = 0; j <= i; j++) {
                    if (bits[j].contains(position)) {
                        // 如果包含 说明当前不能加上去 而且如果是第一次包含的话 那么还要减 1 才行
                        if (bits[j].isFirst(position)) {
                            bits[j].setNotFirst(position);
                            dp[j]--;
                        }
                    } else {
                        bits[j].setBit(position);
                        // 未包含 说明要在之前的基础上 +1
                        dp[j] += 1;
                    }
                    res += dp[j];
                }
            }

            return res;
        }

        private static final class Pair {
            private int bit = 0;

            private int first = 0xFFFF;

            private boolean contains(int position) {
                return ((this.bit >> position) & 1) == 1;
            }

            // 设置 position 的那个位置为 1
            // 如果之前没有重复的 即 之前是 0 那么就变为 1
            private void setBit(int position) {
                this.bit = this.bit | (1 << position);
            }

            private void setNotFirst(int position) {
                this.first = this.first ^ (1 << position);
            }

            private boolean isFirst(int position) {
                return (((this.first) >> position) & 1) == 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}