package ImplementTriePrefixTree208;

public class Trie {

    // 定义一个新的数据结构
    public static class TrieNode {
        public TrieNode[] nodes;
        public boolean isEnd;
        public TrieNode() {
            this.nodes = new TrieNode[26];
            this.isEnd = false;
        }
    }

    private TrieNode node;

    /** Initialize your data structure here. */
    public Trie() {
        this.node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 如果在nodes的现在这个char所指的位置没有 则放进去
            if (temp.nodes[index] == null) {
                temp.nodes[index] = new TrieNode();
            }
            temp = temp.nodes[index];
        }
        temp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 如果在nodes的现在这个char所指的位置没有 则失败
            if (temp.nodes[index] == null) {
                return false;
            }
            temp = temp.nodes[index];
        }
        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = this.node;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            // 如果在nodes的现在这个char所指的位置没有 则失败
            if (temp.nodes[index] == null) {
                return false;
            }
            temp = temp.nodes[index];
        }
        return true;
    }


    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a-'a');
    }
}
