package main

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	return recursionLCA(root, p, q)
}

func recursionLCA(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	} else if p.Val > root.Val && q.Val > root.Val {
		return recursionLCA(root.Right, p, q)
	} else if p.Val < root.Val && q.Val < root.Val {
		return recursionLCA(root.Left, p, q)
	} else {
		return root
	}
}
