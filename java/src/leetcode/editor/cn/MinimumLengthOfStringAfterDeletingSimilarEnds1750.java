//给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次： 
//
// 
// 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。 
// 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。 
// 前缀和后缀在字符串中任意位置都不能有交集。 
// 前缀和后缀包含的所有字符都要相同。 
// 同时删除前缀和后缀。 
// 
//
// 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ca"
//输出：2
//解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
// 
//
// 示例 2： 
//
// 
//输入：s = "cabaabac"
//输出：0
//解释：最优操作序列为：
//- 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
//- 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。 
//
// 示例 3： 
//
// 
//输入：s = "aabccabba"
//输出：3
//解释：最优操作序列为：
//- 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
//- 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含字符 'a'，'b' 和 'c' 。 
// 
//
// Related Topics 双指针 字符串 👍 35 👎 0


package leetcode.editor.cn;

public class MinimumLengthOfStringAfterDeletingSimilarEnds1750 {

    public static void main(String[] args) {
        Solution solution = new MinimumLengthOfStringAfterDeletingSimilarEnds1750().new Solution();
        System.out.println(solution.minimumLength("ca"));
        System.out.println(solution.minimumLength("cabaabac"));
        System.out.println(solution.minimumLength("aabccabba"));
        // 0
        System.out.println(solution.minimumLength("abbbbbbbbbbbbbbbbbbba"));
        // 1
        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLength(String s) {

            int i = 0, j = s.length() - 1;

            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                // i j 相等
                i++;
                j--;

                while (i <= j && s.charAt(i) == s.charAt(i - 1)) {
                    i++;
                }
                while (j >= i && s.charAt(j) == s.charAt(j + 1)) {
                    j--;
                }
            }

            return j - i + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}