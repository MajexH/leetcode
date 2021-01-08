package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := new(TreeNode)
	root.Val = -3
	fmt.Println(maxPathSum(root))
}

var res int = math.MinInt64

func recursionMPS(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left, right := recursionMPS(root.Left), recursionMPS(root.Right)
	res = max(res, left+root.Val, right+root.Val, left+right+root.Val, root.Val)
	return max(max(left, right)+root.Val, root.Val)
}

func maxPathSum(root *TreeNode) int {
	res = math.MinInt64
	recursionMPS(root)
	return res
}

func max(nums ...int) int {
	if nums == nil || len(nums) <= 0 {
		return -1
	}
	res := math.MinInt64
	for _, num := range nums {
		if num > res {
			res = num
		}
	}
	return res
}
