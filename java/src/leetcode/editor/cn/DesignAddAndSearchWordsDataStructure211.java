//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 445 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class DesignAddAndSearchWordsDataStructure211 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class WordDictionary {

        static class Node {
            private Node[] sub;
            private boolean isEnd;

            public Node() {
                this.sub = new Node[26];
                this.isEnd = false;
            }

            public Node get(char c) {
                return this.sub[c - 'a'];
            }

            public void set(char c) {
                this.sub[c - 'a'] = new Node();
            }

            public Node[] getSub() {
                return sub;
            }

            public void setEnd() {
                this.isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }

        private Node node;

        public WordDictionary() {
            this.node = new Node();
        }

        public void addWord(String word) {
            Node tmp = this.node;
            for (char c : word.toCharArray()) {
                if (Objects.isNull(tmp.get(c))) {
                    tmp.set(c);
                }
                tmp = tmp.get(c);
            }
            tmp.setEnd();
        }

        // 因为有通配符 只能递归查找
        public boolean search(String word) {
            return this.recursionSearch(word, 0, this.node);
        }

        private boolean recursionSearch(String word, int index, Node node) {
            if (node == null) {
                return false;
            }

            if (index == word.length()) {
                return node.isEnd();
            }

            char c = word.charAt(index);
            if (c != '.') {
                return this.recursionSearch(word, index + 1, node.get(c));
            }
            // 遍历 node 下所有的
            for (Node sub : node.getSub()) {
                if (sub != null) {
                    if (this.recursionSearch(word, index + 1, sub)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}