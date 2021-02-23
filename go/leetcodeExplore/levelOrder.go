package leetcodeExplore

import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	res := make([][]int, 0)
	tmp := make([]int, 0)
	if root == nil {
		return res
	}

	queue := list.New()
	queue.PushBack(root)
	queue.PushBack(nil)
	for queue.Len() > 0 {
		top := queue.Remove(queue.Front())

		if top == nil {
			cp := make([]int, len(tmp))
			copy(cp, tmp)
			res = append(res, cp)
			if queue.Len() == 0 {
				break
			}
			queue.PushBack(nil)
			tmp = make([]int, 0)
			continue
		}
		t := top.(*TreeNode)
		tmp = append(tmp, t.Val)
		if t.Left != nil {
			queue.PushBack(t.Left)
		}

		if t.Right != nil {
			queue.PushBack(t.Right)
		}
	}
	return res
}
