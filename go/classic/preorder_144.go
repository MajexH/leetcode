package classic

import "container/list"

func preorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)

	stack := list.New()

	for root != nil || stack.Len() > 0 {
		for root != nil {
			res = append(res, root.Val)
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			root = root.Right
		}
	}
	return res
}
