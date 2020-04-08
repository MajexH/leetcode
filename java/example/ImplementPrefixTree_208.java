import java.util.HashMap;

public class ImplementPrefixTree_208 {

    static class Trie {

        public HashMap<Character, Trie> children;
        public boolean end;

        /** Initialize your data structure here. */
        public Trie() {
            this.children = new HashMap<>();
            this.end = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                if (temp.children.containsKey(word.charAt(i))) {
                    temp.end = false;
                } else {
                    temp.children.put(word.charAt(i), new Trie());
                }
                temp = temp.children.get(word.charAt(i));
            }
            temp.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                if (!temp.children.containsKey(word.charAt(i))) {
                    return false;
                }
                temp = temp.children.get(word.charAt(i));
            }
            return temp.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie temp = this;
            for (int i = 0; i < prefix.length(); i++) {
                if (!temp.children.containsKey(prefix.charAt(i))) {
                    return false;
                }
                temp = temp.children.get(prefix.charAt(i));
            }
            return true;
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "children=" + children +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie);
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
