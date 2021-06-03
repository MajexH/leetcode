package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Second {

    // 设计一个二叉树的节点
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    static class Bfs {

        public TreeNode root;

        public Bfs(TreeNode root) {
            this.root = root;
        }


        public Deque<TreeNode> bfs() {
            // 保存结果
            Deque<TreeNode> res = new LinkedList<>();
            if (this.root == null) return res;
            // 保存遍历
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(this.root);

            while (queue.size() != 0) {
                TreeNode top = queue.removeLast();
                res.push(top);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            return res;
        }

        public List<TreeNode> bfsWithGivenLayer(List<TreeNode> layer) {
            // 构建一个入参队列 可以不必
            Deque<TreeNode> queue = new LinkedList<>(layer);
            // 返回的下一层的所有节点
            List<TreeNode> res = new ArrayList<>();
            while (queue.size() > 0) {
                TreeNode top = queue.removeFirst();

                if (top.left != null) {
                    res.add(top.left);
                }
                if (top.right != null) {
                    res.add(top.right);
                }
            }
            return res;
        }

        public Deque<List<TreeNode>> bfsAllNodes() {
            Deque<List<TreeNode>> res = new LinkedList<>();

            List<TreeNode> start = new ArrayList<>();
            start.add(this.root);
            res.push(new ArrayList<>(start));

            while (start.size() != 0) {
                start = this.bfsWithGivenLayer(start);
                res.push(new ArrayList<>(start));
            }

            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);


    }

}
