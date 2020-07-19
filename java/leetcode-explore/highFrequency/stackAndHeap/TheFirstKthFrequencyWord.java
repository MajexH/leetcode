package highFrequency.stackAndHeap;

import java.util.*;

public class TheFirstKthFrequencyWord {

    private class Pair {
        String key;
        int val;

        public Pair(String key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key='" + key + '\'' +
                    ", val=" + val +
                    '}';
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> res = new LinkedList<>();
        if (words == null) return res;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
           map.put(word,  map.getOrDefault(word, 0) + 1);
        }

        // 小顶堆
        PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1.val != p2.val) return p1.val - p2.val;
            else return p2.key.compareTo(p1.key);
        });
        for (String key : map.keySet()) {
            int val = map.get(key);
            heap.offer(new Pair(key, val));
            if (heap.size() > k) heap.poll();
        }

        while (heap.size() > 0) {
            res.push(heap.poll().key);
        }
        return res;
    }


    public static void main(String[] args) {
        //System.out.println("i".compareTo("love"));
        System.out.println(new TheFirstKthFrequencyWord().topKFrequent(new String[]{ "glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"}, 14));
    }
}
