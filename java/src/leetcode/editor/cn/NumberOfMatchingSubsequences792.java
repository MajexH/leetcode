//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 321 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NumberOfMatchingSubsequences792 {
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences792().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // Node 表示的就是桶里面的元素
        // 其中Node保存了 word 和当前的index
        public static class Node {
            String word;
            int index;

            public Node(String w, int i) {
                word = w;
                index = i;
            }
        }

        public int numMatchingSubseq(String S, String[] words) {

            ArrayList<Node>[] heads = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                heads[i] = new ArrayList<>();
            }

            for (String word : words) {
                heads[word.charAt(0) - 'a'].add(new Node(word, 0));
            }

            int res = 0;

            for (char c : S.toCharArray()) {

                ArrayList<Node> bucket = heads[c - 'a'];

                heads[c - 'a'] = new ArrayList<>();

                for (Node node : bucket) {
                    if (node.index + 1 == node.word.length()) {
                        res++;
                        continue;
                    }

                    heads[node.word.charAt(node.index + 1) - 'a'].add(new Node(node.word, node.index + 1));
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}