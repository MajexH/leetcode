package jzoffer

func isBalanced(root *TreeNode) bool {
	res, _ := recursionIsBalanced(root)
	return res
}

func recursionIsBalanced(root *TreeNode) (bool, int) {

	if root == nil {
		return true, 0
	}

	left, leftDepth := recursionIsBalanced(root.Left)
	if !left {
		return false, -1
	}
	right, rightDepth := recursionIsBalanced(root.Right)
	if !right {
		return false, -1
	}

	return abs(leftDepth-rightDepth) <= 1, max(leftDepth, rightDepth) + 1
}

func abs(n int) int {
	y := n >> 63
	return (n ^ y) - y
}
