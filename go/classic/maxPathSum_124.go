package classic

import "math"

// maxPathSum 找到 二叉树 中任意两个节点之间的路径的最大值
func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	res := math.MinInt32
	recursionMaxPathSum(root, &res)
	return res
}

func recursionMaxPathSum(root *TreeNode, res *int) int {
	if root == nil {
		return 0
	}
	left, right := recursionMaxPathSum(root.Left, res), recursionMaxPathSum(root.Right, res)
	*res = maxInArray(*res, left+right+root.Val, left+root.Val, right+root.Val, root.Val)
	return max(root.Val+max(left, right), root.Val)
}

func maxInArray(nums ...int) (res int) {
	res = math.MinInt32
	for _, num := range nums {
		if num > res {
			res = num
		}
	}
	return
}
