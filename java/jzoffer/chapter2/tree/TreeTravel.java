package chapter2.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeTravel {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> preOrder(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                res.add(node.val);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.removeLast();
                node = node.right;
            }
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.removeLast();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public List<Integer> postOrder(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        // 表示是否是第二次访问
        Deque<Boolean> stackForBool = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                stackForBool.add(Boolean.FALSE);
                node = node.left;
            }
            if (stack.size() > 0) {
                boolean isSecondTravel = stackForBool.removeLast();
                node = stack.removeLast();
                // 是第二次访问
                if (isSecondTravel) {
                    res.add(node.val);
                    // 第二次访问 就需要再次从 stack 里面拿东西
                    node = null;
                } else {
                    // 第一次访问
                    stack.add(node);
                    stackForBool.add(Boolean.TRUE);
                    // 第一次访问到 就需要去访问他的右子节点
                    node = node.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.right = new TreeNode(14);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right.right = new TreeNode(16);
        node.right.left = new TreeNode(12);
        System.out.println(new TreeTravel().preOrder(node));
        System.out.println(new TreeTravel().inOrder(node));
        System.out.println(new TreeTravel().postOrder(node));
    }
}
