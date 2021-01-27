package jzoffer

// mirrorTree 返回二叉树的镜像 其实反转这个二叉树即可
func mirrorTree(root *TreeNode) *TreeNode {
	reverseTree(root)
	return root
}

func reverseTree(root *TreeNode) {
	if root == nil {
		return
	}
	tmp := root.Left
	root.Left = root.Right
	root.Right = tmp
	reverseTree(root.Left)
	reverseTree(root.Right)
}
