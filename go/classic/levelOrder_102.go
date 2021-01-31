package classic

import "container/list"

func levelOrder(root *TreeNode) [][]int {
	res := make([][]int, 0)
	if root == nil {
		return res
	}
	tmp := make([]int, 0)
	queue := list.New()
	queue.PushBack(root)
	queue.PushBack(nil)
	for queue.Len() > 0 {
		node := queue.Remove(queue.Front())
		if node == nil {
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
		top := node.(*TreeNode)
		if top.Left != nil {
			queue.PushBack(top.Left)
		}
		if top.Right != nil {
			queue.PushBack(top.Right)
		}
		tmp = append(tmp, top.Val)
	}
	return res
}
