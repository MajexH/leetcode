package highFrequency.map;

import java.util.*;

public class LadderLengthNew {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String tmp = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new ArrayList<>());
                }
                map.get(tmp).add(word);
            }
        }
        int res = 1;
        Deque<String> queue = new LinkedList<>();
        Set<String> marked = new HashSet<>();
        queue.add(beginWord);
        queue.add(null);
        while (!queue.isEmpty()) {
            String first = queue.removeFirst();
            marked.add(first);
            if (first == null) {
                res++;
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            for (int i = 0; i < beginWord.length(); i++) {
                String tmp = first.substring(0, i) + "*" + first.substring(i + 1);
                for (String word : map.getOrDefault(tmp, new ArrayList<>())) {
                    if (marked.contains(word)) continue;
                    if (word.equals(endWord)) {
                        return res + 1;
                    }
                    queue.add(word);
                }
            }
        }
        // 找不到
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LadderLengthNew().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(new LadderLengthNew().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","log")));

    }
}
