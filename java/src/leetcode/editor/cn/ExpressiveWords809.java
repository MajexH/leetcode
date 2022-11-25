//有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串
//字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。 
//
// 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下
//：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。 
//
// 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 
//长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词
// "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = 
//s。 
//
// 输入一组查询单词，输出其中可扩张的单词数量。 
//
// 
//
// 示例： 
//
// 
//输入： 
//s = "heeellooo"
//words = ["hello", "hi", "helo"]
//输出：1
//解释：
//我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
//我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, words.length <= 100 
// 1 <= words[i].length <= 100 
// s 和所有在 words 中的单词都只由小写字母组成。 
// 
//
// Related Topics 数组 双指针 字符串 👍 88 👎 0


package leetcode.editor.cn;

public class ExpressiveWords809 {
    public static void main(String[] args) {
        Solution solution = new ExpressiveWords809().new Solution();
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(solution.expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {

            int res = 0;

            for (String word : words) {
                if (this.canExpressive(s, word)) {
                    res++;
                }
            }

            return res;
        }

        private boolean canExpressive(String s, String word) {

            // 是一组相同的 char 所以如果不相同就有问题
            // iiii ii 那么是可以的 因为是从 第一个 i 开始匹配 超过 3 个
            int i = 0, j = 0;

            while (i < s.length() && j < word.length()) {

                if (s.charAt(i) != word.charAt(j)) {
                    return false;
                }

                // 处理相等的情况 这里要跳过相等的
                char c1 = s.charAt(i);
                int len1 = 0;
                while (i < s.length() && s.charAt(i) == c1) {
                    i++;
                    len1++;
                }

                char c2 = word.charAt(j);
                int len2 = 0;
                while (j < word.length() && word.charAt(j) == c2) {
                    j++;
                    len2++;
                }

                if (len1 < len2) {
                    return false;
                }

                if (len1 > len2 && len1 < 3) {
                    return false;
                }
            }

            return i == s.length() && j == word.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}