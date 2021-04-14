public class Trie {

    private static class Node {

        Node[] next;
        boolean isEnd;

        public Node() {
            // 仅由小写字母组成
            this.next = new Node[26];
            this.isEnd = false;
        }

        public Node getNext(char c) {
            return this.next[c - 'a'];
        }

        public void setNext(char c) {
            this.next[c - 'a'] = new Node();
        }
    }

    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = this.root;

        for (char c : word.toCharArray()) {
            if (node.getNext(c) == null) {
                node.setNext(c);
            }
            node = node.getNext(c);
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = this.root;

        for (char c : word.toCharArray()) {
            if (node.getNext(c) == null) {
                return false;
            }
            node = node.getNext(c);
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = this.root;

        for (char c : prefix.toCharArray()) {
            if (node.getNext(c) == null) {
                return false;
            }
            node = node.getNext(c);
        }
        return true;
    }
}
