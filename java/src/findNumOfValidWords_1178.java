import java.util.*;

public class findNumOfValidWords_1178 {

    private class TrieTree {
        int currency;
        TrieTree[] child;

        public TrieTree() {
            this.currency = 0;
            // 因为只包含小写字母
            this.child = new TrieTree[26];
        }

        public void add(char[] word) {
            TrieTree cur = this;

            for (char c : word) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieTree();
                }
                cur = cur.child[c - 'a'];
            }
            // currency 表示有一个 word 到达了这个底
            cur.currency++;
        }
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 因为实际上并不在意 word 的顺序 而且根据题目要求 word 不定长 而且比 puzzle 大 因为 puzzle 是 7 为固定长度
        // 所以固定 word 为 字符树

        TrieTree root = new TrieTree();
        // 加入字典树中相当于 压缩了 words
        for (String word : words) {
            // 排序去重加入 因为这样才能统计 currency 并进行压缩
            root.add(getCharArray(word));
        }
        List<Integer> res = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            res.add(0);
        }

        // 比较 puzzle 与 字典树
        // puzzle 最大深度为 7
        // 最后只需要加上 currency 即可
        for (int i = 0; i < puzzles.length; i++) {
            char[] puzzleArray = getCharArray(puzzles[i]);
            char required = puzzles[i].charAt(0);
            res.set(i, recursionSearch(root, puzzleArray, 0, required));
        }
        return res;
    }

    // puzzle 去匹配字典树 找到一个 节点 返回其 currency 即对应的 word 数量
    public int recursionSearch(TrieTree node, char[] puzzleArray, int pos, char required) {
        if (node == null) {
            return 0;
        }
        // puzzle 最深就打到这儿
        if (pos == puzzleArray.length) {
            return node.currency;
        }

        // 可以选择用当前 pos 这个位置来匹配 然后都 ++
        int res = recursionSearch(node.child[puzzleArray[pos] - 'a'], puzzleArray, pos + 1, required);
        // 因为去重了 所以 required 等于的时候 一定要匹配

        // 不等于的时候，可以维持 node 引用 然后不匹配 跳过 puzzle 的这个字符 继续往下走
        if (puzzleArray[pos] != required) {
            // + 是因为 可以用多条路走 实际上就是要或者不要
            res += recursionSearch(node, puzzleArray, pos + 1, required);
        }
        return res;
    }

    public char[] getCharArray(String word) {
        char[] tmp = word.toCharArray();
        Arrays.sort(tmp);
        int newIndex = 0;
        int l = 0, r = 0;
        while (r < tmp.length) {
            while (r < tmp.length && tmp[r] == tmp[l]) {
                r++;
            }
            tmp[newIndex++] = tmp[l];
            l = r;
        }
        char[] res = new char[newIndex];
        System.arraycopy(tmp, 0, res, 0, newIndex);
        return res;
    }


    // 将每个 puzzle 作为一个 set 传入 那样只需要检查 puzzle 是否符合要求即可
    // 但是超时
    public List<Integer> findNumOfValidWordsWithSet(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            res.add(0);
        }

        Set[] puzzlesSet = new Set[puzzles.length];

        for (int i = 0; i < puzzles.length; i++) {
            puzzlesSet[i] = makePuzzleSet(puzzles[i]);
        }

        for (String word : words) {
            for (int j = 0; j < puzzles.length; j++) {
                // 单词 word 中包含 puzzles[j] 的第一个字母
                if (check(word, (Set<Character>) puzzlesSet[j], puzzles[j])) {
                    res.set(j, res.get(j) + 1);
                }
            }
        }

        return res;
    }

    private Set<Character> makePuzzleSet(String puzzle) {
        Set<Character> set = new HashSet<Character>();
        for (char c : puzzle.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private boolean check(String word, Set<Character> puzzle, String puzzleStr) {
        // 默认不包含第一个字母
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (!puzzle.contains(word.charAt(i))) return false;
            if (word.charAt(i) == puzzleStr.charAt(0)) flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new findNumOfValidWords_1178().findNumOfValidWords(
                new String[]{"apple", "pleas", "please"},
                new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}));

    }
}
