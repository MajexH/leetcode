package main

import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	stack := list.New()
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() > 0 {
			root = (stack.Back().Value).(*TreeNode)
			stack.Remove(stack.Back())
			k--
			if 0 == k {
				return root.Val
			}
			root = root.Right
		}
	}
	return -1
}
