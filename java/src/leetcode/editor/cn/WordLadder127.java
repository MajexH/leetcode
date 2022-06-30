package leetcode.editor.cn;//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 ->
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 1061 👎 0


import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        Solution solution = new WordLadder127().new Solution();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) {
                return 0;
            }

            Map<String, List<String>> map = new HashMap<>();

            for (String word : wordList) {
                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i) + "*" + word.substring(i + 1);
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
                }
            }

            int res = 1;

            Set<String> alreadyTraveledKey = new HashSet<>();

            Deque<String> queue = new LinkedList<>();
            queue.addLast(beginWord);
            queue.addLast(null);

            // 广搜
            while (!queue.isEmpty()) {
                String top = queue.removeFirst();

                // 一层结束
                if (Objects.isNull(top)) {
                    res++;
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.addLast(null);
                    continue;
                }

                if (alreadyTraveledKey.contains(top)) {
                    continue;
                }

                alreadyTraveledKey.add(top);
                for (int i = 0; i < top.length(); i++) {
                    String key = top.substring(0, i) + "*" + top.substring(i + 1);

                    for (String otherKey : map.getOrDefault(key, new ArrayList<>())) {
                        if (otherKey.equals(endWord)) {
                            return res + 1;
                        }
                        queue.addLast(otherKey);
                    }
                }

            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}