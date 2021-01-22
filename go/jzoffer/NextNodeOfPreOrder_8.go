package jzoffer

type TreeNodeWithFather struct {
	Value               int
	Left, Right, Father *TreeNodeWithFather
}

// getNextNode 输入一个节点 找到其中序遍历的下一个节点
func getNextNode(root *TreeNodeWithFather) *TreeNodeWithFather {
	if root == nil {
		return nil
	}
	// 1. 第一种情况是 父节点存在且为父节点的左子节点 那么中序遍历的下一个节点就是父节点
	if root.Father != nil && root.Father.Left == root {
		return root.Father
	}

	// 2. 如果是父节点的右子节点 那么下一个中序遍历的节点 就是找到父亲节点是上一个父亲节点的左子节点
	if root.Father != nil && root.Father.Right == root {
		mov := root.Father
		for mov != nil && mov.Father != nil {
			if mov.Father.Left == mov {
				return mov.Father
			}
			mov = mov.Father
		}
	}
	return nil
}
