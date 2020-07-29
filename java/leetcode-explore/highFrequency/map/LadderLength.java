package highFrequency.map;

import java.util.*;

public class LadderLength {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 邻接表表示图
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            // 构建一个 word 的带通配符的 key 放入到 邻接表中
            for (int i = 0; i < word.length(); i++) {
                String temp = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> tempList = map.getOrDefault(temp, new ArrayList<>());
                tempList.add(word);
                map.put(temp, tempList);
            }
        }
        Queue<String> bfs = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        Set<String> memo = new HashSet<>();
        bfs.add(beginWord);
        levels.add(1);
        while (bfs.size() > 0) {
            String top = bfs.poll();
            Integer topLevel = levels.poll();
            // 构建当前的通配符
            for (int i = 0; i < top.length(); i++) {
                String temp = top.substring(0, i) + "*" + top.substring(i + 1);
                // 遍历当前的 top 形成的通配符
                for (String adjacent : map.getOrDefault(temp, new ArrayList<>())) {
                    // 说明访问过了
                    if (memo.contains(adjacent)) continue;
                    // 到达结尾
                    assert topLevel != null;
                    if (adjacent.equals(endWord)) return topLevel + 1;
                    memo.add(adjacent);
                    bfs.add(adjacent);
                    levels.add(topLevel + 1);
                }
            }
        }
        // 找不到一个变幻
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
//        list.add("cog");
        System.out.println(new LadderLength().ladderLength("hit", "cog", list));
    }
}
