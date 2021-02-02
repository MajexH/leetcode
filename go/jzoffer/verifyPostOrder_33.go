package jzoffer

import "math"

func verifyPostorder(postorder []int) bool {
	return recursionVeryPostOrder(postorder, math.MinInt32, math.MaxInt32)
}

func recursionVeryPostOrder(postOrder []int, min, max int) bool {
	if len(postOrder) == 0 {
		return true
	}
	root := postOrder[len(postOrder)-1]
	// 检查数字是否满足范围
	for _, num := range postOrder {
		if num < min || num > max {
			return false
		}
	}
	// 找到分隔点
	i := 0
	for i < len(postOrder)-1 && root > postOrder[i] {
		i++
	}

	return recursionVeryPostOrder(postOrder[:i], min, root) && recursionVeryPostOrder(postOrder[i:len(postOrder)-1], root, max)
}
