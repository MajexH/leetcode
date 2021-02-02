package classic

import "container/list"

func postorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)

	stack := list.New()
	// 标识这个node是不是第二次访问
	stackForFlag := list.New()
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			stackForFlag.PushBack(false)
			root = root.Left
		}

		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			flag := stackForFlag.Remove(stackForFlag.Back()).(bool)

			// 说明是第二次访问 这个时候要访问父亲节点
			if flag {
				res = append(res, root.Val)
				root = nil
			} else {
				// 第一次访问
				stack.PushBack(root)
				stackForFlag.PushBack(true)
				root = root.Right
			}
		}
	}
	return res
}

func postorderTraversalWithRecursion(root *TreeNode) []int {
	res := make([]int, 0)
	recursionPostTravel(root, &res)
	return res
}

func recursionPostTravel(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	recursionPostTravel(root.Left, res)
	recursionPostTravel(root.Right, res)
	*res = append(*res, root.Val)
}
