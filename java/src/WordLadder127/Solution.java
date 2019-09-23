package WordLadder127;

import java.util.*;

public class Solution {

    // 其实就是建立一个图 这个图里面的节点是一个一个单词 连接起来的应该是只有一个单词只差的词语
    // 最后通过BST来直接拿到最短的距离
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 所有的单词都是一样的长度
        int length = beginWord.length();
        // 用来保存一个状态的邻接端点
        HashMap<String, List<String>> adjacents = new HashMap<>();
        wordList.forEach((word) -> {
            // 针对每个单词 构建 一个包含通配符的状态
            for (int i = 0; i < length; i++) {
                String temp = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = adjacents.getOrDefault(temp, new ArrayList<>());
                list.add(word);
                adjacents.put(temp, list);
            }
        });
        int level = 1;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        queue.add(null);
        while (queue.size() != 0) {
            // 拿到头
            String top = queue.remove();
            if (top == null) {
                // 遍历完了所有的都没有找到
                if (queue.size() == 0) break;

                // 遍历完了一层
                level++;
                queue.add(null);
                continue;
            }
            for (int i = 0; i < length; i++) {
                String temp = top.substring(0, i) + "*" + top.substring(i + 1);
                for (String adjacent : adjacents.getOrDefault(temp, new ArrayList<>())) {
                    if (adjacent.equals(endWord)) return level + 1;
                    if (!visited.contains(adjacent)) {
                        queue.add(adjacent);
                        visited.add(adjacent);
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");
        System.out.println(new Solution().ladderLength("hit", "cog", wordList));
    }
}
