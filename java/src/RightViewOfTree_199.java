import java.util.*;

public class RightViewOfTree_199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Integer[] res = new Integer[depth(root)];
        if (root == null) return new ArrayList<>(Arrays.asList(res));
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> levelStack = new LinkedList<>();
        nodeStack.push(root);
        levelStack.push(0);

        while (nodeStack.size() > 0) {
            TreeNode top = nodeStack.pop();
            int level = levelStack.pop();

            if (top.left != null) {
                nodeStack.push(top.left);
                levelStack.push(level + 1);
            }

            if (top.right != null) {
                nodeStack.push(top.right);
                levelStack.push(level + 1);
            }
            // 因为right后入站 因此最先访问的是right
            if (res[level] == null) {
                res[level] = top.val;
            }
        }

        return new ArrayList<>(Arrays.asList(res));
    }

    public static void main(String[] args) {
        System.out.println(new RightViewOfTree_199().rightSideView(null));
    }
}
