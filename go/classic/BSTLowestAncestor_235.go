package classic

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

func bstLowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	return recursionBSTLowestAncestor(root, p, q)
}

func recursionBSTLowestAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if p.Val < root.Val && q.Val < root.Val {
		return recursionBSTLowestAncestor(root.Left, p, q)
	} else if p.Val > root.Val && q.Val > root.Val {
		return recursionBSTLowestAncestor(root.Right, p, q)
	}
	return root
}
