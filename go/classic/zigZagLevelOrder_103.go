package classic

import "container/list"

func zigzagLevelOrder(root *TreeNode) [][]int {

	res := make([][]int, 0)
	if root == nil {
		return res
	}
	isLeft := true
	tmp := make([]int, 0)
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
			isLeft = !isLeft
			tmp = make([]int, 0)
			queue.PushBack(nil)
			continue
		}
		node := top.(*TreeNode)
		if node.Left != nil {
			queue.PushBack(node.Left)
		}
		if node.Right != nil {
			queue.PushBack(node.Right)
		}

		if isLeft {
			tmp = append(tmp, node.Val)
		} else {
			tmp = append([]int{node.Val}, tmp...)
		}
	}
	return res
}
