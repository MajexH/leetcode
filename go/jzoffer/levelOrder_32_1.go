package jzoffer

import "container/list"

func levelOrder(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}

	queue := list.New()
	queue.PushBack(root)

	for queue.Len() > 0 {
		top := queue.Remove(queue.Front()).(*TreeNode)
		res = append(res, top.Val)
		if top.Left != nil {
			queue.PushBack(top.Left)
		}
		if top.Right != nil {
			queue.PushBack(top.Right)
		}
	}
	return res
}
