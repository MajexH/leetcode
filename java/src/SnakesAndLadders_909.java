import java.util.*;

public class SnakesAndLadders_909 {

    private static class Node {
        int val;
        int level;

        public Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    // 如果要跳 就全部直接跳了
    public int snakesAndLadders(int[][] board) {
        List<Integer> list = new ArrayList<>();

        boolean left = false;
        for (int i = board.length - 1; i >= 0; i--) {
            left = !left;
            if (left) {
                for (int j = 0; j < board[i].length; j++) {
                    list.add(board[i][j]);
                }
                continue;
            }

            for (int j = board[i].length - 1; j >= 0; j--) {
                list.add(board[i][j]);
            }
        }
        int target = board.length * board.length - 1;
        Deque<Node> queue = new LinkedList<>();
        Set<Integer> memo = new HashSet<>();

        queue.add(new Node(0, 0));
        memo.add(0);
        while (!queue.isEmpty()) {
            Node top = queue.removeFirst();
            memo.add(top.val);
            // 下一跳
            for (int i = top.val + 1; i < Math.min(board.length * board.length, top.val + 7); i++) {
                Node node = null;
                if (list.get(i) == -1) {
                    node = new Node(i, top.level + 1);
                } else {
                    // 下一跳如果是可以再跳 就直接跳了
                    node = new Node(list.get(i) - 1, top.level + 1);
                }
                if (node.val == target) return top.level + 1;
                if (memo.contains(node.val)) continue;
                memo.add(node.val);
                queue.add(node);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SnakesAndLadders_909().snakesAndLadders(new int[][]{
                {-1, 1, 2, -1},
                {2, 13, 15, -1},
                {-1, 10, -1, -1},
                {-1, 6, 2, 8}
        }));
    }
}
