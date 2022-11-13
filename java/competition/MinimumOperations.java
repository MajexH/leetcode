package competition;

import java.util.*;

public class MinimumOperations {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(3);
        System.out.println(new MinimumOperations().minimumOperations(node));
    }

    public int minimumOperations(TreeNode root) {
        // 中序遍历

        List<Pair> level = new ArrayList<>();

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        nodes.addLast(null);

        int res = 0;
        while (!nodes.isEmpty()) {
            TreeNode first = nodes.removeFirst();

            if (Objects.isNull(first)) {
                // 判断
                res += this.swapCounter(level);
                level = new ArrayList<>();
                if (nodes.isEmpty()) {
                    break;
                }
                nodes.addLast(null);
                continue;
            }

            level.add(new Pair(first.val, level.size()));
            if (first.left != null) {
                nodes.addLast(first.left);
            }

            if (first.right != null) {
                nodes.add(first.right);
            }
        }


        return res;
    }

    // 把对应的数据 交换到对应的位置上
    private int swapCounter(List<Pair> level) {
        int res = 0;
        level.sort(Comparator.comparingInt(a -> a.val));

        for (int i = 0; i < level.size(); i++) {
            // 在当前的位置上
            if (level.get(i).index == i) {
                continue;
            }
            // 不在位置上就交换
            this.swap(level, i, level.get(i).index);
            if (i != level.get(i).index) {
                i--;
            }
            res++;
        }
        return res;
    }

    private void swap(List<Pair> level, int i, int j) {
        Pair tmp = level.get(i);
        level.set(i, level.get(j));
        level.set(j, tmp);
    }

    private static final class Pair {
        int val, index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
