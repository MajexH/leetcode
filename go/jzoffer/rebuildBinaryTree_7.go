package jzoffer

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	return recursion(preorder, inorder)
}

func recursion(pre, in []int) *TreeNode {
	if len(pre) == 0 {
		return nil
	}
	node := new(TreeNode)
	node.Val = pre[0]
	index := findIndex(in, node.Val)
	if index == -1 {
		return nil
	}
	node.Left = recursion(pre[1:index+1], in[:index])
	node.Right = recursion(pre[index+1:], in[index+1:])
	return node
}

func findIndex(array []int, target int) int {
	for i, num := range array {
		if target == num {
			return i
		}
	}
	return -1
}
