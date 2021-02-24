package highFrequency.stackAndHeap;

import java.util.*;

public class TopKFrequencyWord {

    private class Pair {
        String key;
        int val;

        public Pair(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.val == p2.val) {
                return p2.key.compareTo(p1.key);
            }
            return p1.val - p2.val;
        });

        for (String key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
            if (pq.size() > k) pq.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        while (pq.size() > 0) {
            res.push(pq.poll().key);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequencyWord().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequencyWord().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
