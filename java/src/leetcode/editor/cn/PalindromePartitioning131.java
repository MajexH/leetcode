package leetcode.editor.cn;//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1185 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning131().new Solution();
        System.out.println(solution.partition("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            // 这个方法是通过 recursion 直接在底层拿到结果
//            return this.recursion(s, 0);
            List<List<String>> res = new ArrayList<>();
            this.recursion(s, 0, new ArrayList<>(), res);
            return res;
        }

        private void recursion(String s, int start, List<String> tmp, List<List<String>> res) {
            if (start >= s.length()) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (this.isPalindrome(s, start, i)) {
                    tmp.add(s.substring(start, i + 1));
                    this.recursion(s, i + 1, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }

        private List<List<String>> recursion(String s, int start) {

            List<List<String>> res = new ArrayList<>();
            for (int i = start + 1; i <= s.length(); i++) {
                if (isPalindrome(s, start, i - 1)) {
                    String subStr = s.substring(start, i);
                    List<List<String>> sub = this.recursion(s, i);

                    if (sub.size() == 0) {
                        res.add(Arrays.asList(subStr));
                    } else {
                        res.addAll(sub.stream().map(list -> {
                            List<String> tmp = new ArrayList<>();
                            tmp.add(subStr);
                            tmp.addAll(list);
                            return tmp;
                        }).collect(Collectors.toList()));
                    }
                }
            }
            return res;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}