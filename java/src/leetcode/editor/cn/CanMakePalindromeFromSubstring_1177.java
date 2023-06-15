//给你一个字符串 s，请你对 s 的子串进行检测。
//
// 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[
//right]，并从中选择 最多 k 项替换成任何小写英文字母。
//
// 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
//
// 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
//
// 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换
//其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
//
//
//
// 示例：
//
// 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
//输出：[true,false,false,true,true]
//解释：
//queries[0] : 子串 = "d"，回文。
//queries[1] : 子串 = "bc"，不是回文。
//queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
//queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd"
//替换为 "ab"。
//queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
//
//
//
//
// 提示：
//
//
// 1 <= s.length, queries.length <= 10^5
// 0 <= queries[i][0] <= queries[i][1] < s.length
// 0 <= queries[i][2] <= s.length
// s 中只有小写英文字母
//
//
// Related Topics 位运算 数组 哈希表 字符串 前缀和 👍 101 👎 0


package src.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring_1177 {
    public static void main(String[] args) {
        Solution solution = new CanMakePalindromeFromSubstring_1177().new Solution();
        System.out.println(solution.canMakePaliQueries("abcda", new int[][]{
                {3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}
        }));

        System.out.println(solution.canMakePaliQueries("hunu", new int[][]{
                {1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 2}, {1, 3, 3}, {2, 3, 1}, {3, 3, 1}, {0, 3, 0}, {1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 1}, {1, 1, 1}
        }));

        System.out.println(solution.canMakePaliQueries("rkzavgdmdgt", new int[][]{
                {5, 8, 0}, {7, 9, 1}, {3, 6, 4}, {5, 5, 1}, {8, 10, 0}, {3, 9, 5}, {0, 10, 10}, {6, 8, 3}
        }));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            List<Boolean> res = new ArrayList<>();
            int[][] characterCounter = new int[s.length()][26];

            for (int i = 0; i < s.length(); i++) {
                int cIndex = s.charAt(i) - 'a';

                if (i == 0) {
                    characterCounter[0][cIndex] = 1;
                    continue;
                }
                // 拿到 pre
                System.arraycopy(characterCounter[i - 1], 0, characterCounter[i], 0, 26);
                characterCounter[i][cIndex] += 1;
            }

            for (int[] query : queries) {

                // 可以重新排列子串 意味着可以改变原始的位置 那只需要统计不为偶数的字符串有多少个 减一
                int k = query[2];

                // 两个 int 做位运算
                // 每一位相减为 奇数 的就要单独计算
                int[] left;
                if (query[0] == 0) {
                    left = new int[26];
                } else {
                    left = characterCounter[query[0] - 1];
                }
                int[] right = characterCounter[query[1]];
                int odds = 0;

                for (int i = 0; i < 26; i++) {
                    int counter = right[i] - left[i];
                    odds += (counter & 1);
                }

                odds = (int) Math.ceil(odds / 2D);

                // 如果原始的长度是 奇数 那么可以留一个奇数
                int length = query[1] - query[0] + 1;
                if ((length & 1) == 1) {
                    odds--;
                }

                res.add(k >= odds);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}