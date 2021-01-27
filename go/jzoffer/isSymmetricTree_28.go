package jzoffer

func isSymmetric(root *TreeNode) bool {
	return recursionIsSymmetric(root, root)
}

func recursionIsSymmetric(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	return left.Val == right.Val &&
		recursionIsSymmetric(left.Left, right.Right) &&
		recursionIsSymmetric(left.Right, right.Left)
}
