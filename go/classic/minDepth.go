package classic

// minDepth 求根节点到叶子节点的最短距离 (一定要找到叶子节点)
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil {
		return minDepth(root.Right) + 1
	}
	if root.Right == nil {
		return minDepth(root.Left) + 1
	}
	return min(minDepth(root.Right), minDepth(root.Left)) + 1
}
