import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance_1600 {

    private static class TreeNode {
        String name;
        boolean isDead = false;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(String name) {
            this.name = name;
        }
    }

    private TreeNode root;
    private Map<String, TreeNode> memo = new HashMap<>();

    public ThroneInheritance_1600(String kingName) {
        this.root = new TreeNode(kingName);
        memo.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        TreeNode child = new TreeNode(childName);
        memo.get(parentName).children.add(child);
        memo.put(childName, child);
    }

    public void death(String name) {
        memo.get(name).isDead = true;
    }

    // 除去死亡人员的
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        recursion(this.root, res);
        return res;
    }

    private void recursion(TreeNode node, List<String> res) {
        if (node == null) {
            return;
        }
        if (!node.isDead) res.add(node.name);
        for (TreeNode child : node.children) {
            recursion(child, res);
        }
    }
}
