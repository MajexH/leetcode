package classic

import "container/list"

// recoverTree 因为可能存在两对逆序的 找到两对逆序的
// 分别纪律 第一个逆序的头 第二个逆序的 尾即可
// 但是要注意的是 可能存在一个逆序
func recoverTree(root *TreeNode) {
	var first, second *TreeNode
	var pre *TreeNode
	stack := list.New()

	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			if pre != nil {
				// 找到一个逆序的
				if pre.Val > root.Val {
					if first == nil {
						first = pre
					}
					second = root
				}
			}
			pre = root
			root = root.Right
		}
	}

	if first != nil {
		tmp := first.Val
		first.Val = second.Val
		second.Val = tmp
	}
}
