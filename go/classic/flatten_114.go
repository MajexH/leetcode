package classic

// flatten
func flatten(root *TreeNode) {
	recursionFlatten(root)
}

func recursionFlatten(root *TreeNode) {
	if root == nil {
		return
	}
	recursionFlatten(root.Left)
	recursionFlatten(root.Right)

	left := root.Left
	if left == nil {
		return
	}
	for left.Right != nil {
		left = left.Right
	}
	left.Right = root.Right
	root.Right = root.Left
	root.Left = nil
}
