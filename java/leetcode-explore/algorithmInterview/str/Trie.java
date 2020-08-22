package algorithmInterview.str;

public class Trie {

    public Trie[] children;
    public boolean isEnd = false;

    /** Initialize your data structure here. */
    public Trie() {
        // 保证输入只有小写字母
        this.children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = this;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (char c : prefix.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}
