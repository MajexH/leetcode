package algorithmInterview.str;

import java.util.*;

public class WordSearchII {

    public static class TierNode {
        Map<Character, TierNode> children;
        // 不为 null 说明是一个出现的 单词
        public String str = null;
        public TierNode() {
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            TierNode temp = this;
            for (char c : word.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TierNode());
                }
                temp = temp.children.get(c);
            }
            // 最后一层的 str 加入即可
            temp.str = word;
        }

    }

    public void recursion(char[][] board, int i, int j, TierNode node, boolean[][] memo, Set<String> res) {
        TierNode curNode = node.children.get(board[i][j]);
        if (curNode.str != null) {
            // 说明找到了一个
            res.add(curNode.str);
            // 为了剪枝
            curNode.str = null;
        }
        memo[i][j] = true;
        if (i + 1 < board.length && !memo[i + 1][j] && curNode.children.containsKey(board[i + 1][j])) {
            recursion(board, i + 1, j, curNode, memo, res);
        }
        if (i - 1 >= 0 && !memo[i - 1][j] && curNode.children.containsKey(board[i - 1][j])) {
            recursion(board, i - 1, j, curNode, memo, res);
        }
        if (j + 1 < board[i].length && !memo[i][j + 1] && curNode.children.containsKey(board[i][j + 1])) {
            recursion(board, i, j + 1, curNode, memo, res);
        }
        if (j - 1 >= 0 && !memo[i][j - 1] && curNode.children.containsKey(board[i][j - 1])) {
            recursion(board, i, j - 1, curNode, memo, res);
        }
        // 重新置位没访问过
        memo[i][j] = false;
        if (curNode.children.isEmpty())
            node.children.remove(board[i][j]);
    }

    // 这个问题不同于之前的 是一个大数据量的问题
    // 尤其是在 words 也有很多个的情况
    public List<String> findWords(char[][] board, String[] words) {
        TierNode root = new TierNode();
        for (String word : words) {
            root.insert(word);
        }
        Set<String> res = new HashSet<>();
        boolean[][] memo = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    recursion(board, i, j, root, memo, res);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
