package classic

import (
	"container/list"
	"math"
)

// isValidBST1 bst 的中序遍历是一个递增的数组
func isValidBST1(root *TreeNode) bool {
	stack := list.New()
	var pre *TreeNode
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}

		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			if pre != nil && pre.Val >= root.Val {
				return false
			}
			pre = root
			root = root.Right
		}
	}
	return true
}

// isValidBST bst 的中序遍历是一个递增的数组
func isValidBST(root *TreeNode) bool {
	return recursionIsValidBst(root, math.MinInt64, math.MaxInt64)
}

func recursionIsValidBst(node *TreeNode, low, high int64) bool {
	if node == nil {
		return true
	}

	if int64(node.Val) >= high || int64(node.Val) <= low {
		return false
	}
	return recursionIsValidBst(node.Left, low, int64(node.Val)) && recursionIsValidBst(node.Right, int64(node.Val), high)
}
