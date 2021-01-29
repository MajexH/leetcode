package classic

import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)

	stack := list.New()

	for root != nil || stack.Len() != 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			res = append(res, root.Val)
			root = root.Right
		}
	}
	return res
}
