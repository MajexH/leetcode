package binarySearch

import "math"

// 在二叉树 root 中找到最接近 target 的数值
func closestValue(root *TreeNode, target float64) int {
	if root == nil {
		return -1
	}
	res := float64(root.Val)
	recursionClosestValue(root, target, &res)
	return int(res)
}

func recursionClosestValue(node *TreeNode, target float64, res *float64) {
	if node == nil {
		return
	}
	val := float64(node.Val)
	diff := math.Abs(val - target)
	if diff < math.Abs(*res-target) {
		*res = val
	}

	if target > val {
		recursionClosestValue(node.Right, target, res)
	} else if target < val {
		recursionClosestValue(node.Left, target, res)
	} else {
		*res = val
	}
}
