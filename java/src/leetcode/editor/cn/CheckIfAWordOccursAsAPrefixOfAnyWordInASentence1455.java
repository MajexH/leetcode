//给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 
//searchWord 是否为句子 sentence 中任意单词的前缀。 
//
// 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个
//单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。 
//
// 字符串 s 的 前缀 是 s 的任何前导连续子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：sentence = "i love eating burger", searchWord = "burg"
//输出：4
//解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。 
//
// 示例 2： 
//
// 
//输入：sentence = "this problem is an easy problem", searchWord = "pro"
//输出：2
//解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
// 
//
// 示例 3： 
//
// 
//输入：sentence = "i am tired", searchWord = "you"
//输出：-1
//解释："you" 不是句子中任何单词的前缀。
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 100 
// 1 <= searchWord.length <= 10 
// sentence 由小写英文字母和空格组成。 
// searchWord 由小写英文字母组成。 
// 
// Related Topics 字符串 字符串匹配 👍 70 👎 0


package leetcode.editor.cn;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455 {
    public static void main(String[] args) {
        Solution solution = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (this.isPrefix(words[i], searchWord)) {
                    return i + 1;
                }
            }

            return -1;
        }

        private boolean isPrefix(String word, String prefix) {
            if (word.length() < prefix.length()) {
                return false;
            }
            for (int i = 0; i < prefix.length(); i++) {
                if (word.charAt(i) != prefix.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}