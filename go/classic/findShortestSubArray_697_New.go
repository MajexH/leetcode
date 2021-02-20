package classic

import "math"

// 找到一个最短的子数组 其度与最大的数组相同
// 数组的度是指 任一元素出现的频数的最大值
func findShortestSubArray(nums []int) int {
	// 计算度的话 因为要找到最短的数组长度 所以实际上数组里面一定包含 数字的 度 为 数组度的所有数字
	// 所以只需要知道这些数字中 最短的数字是啥 即可

	type DegreeNode struct {
		degree, beginIndex, endIndex int
	}
	degree := 0
	memo := make(map[int]*DegreeNode)
	for i, num := range nums {
		if node, ok := memo[num]; ok {
			node.degree++
			node.endIndex = i
		} else {
			node := &DegreeNode{
				degree:     1,
				beginIndex: i,
				endIndex:   i,
			}
			memo[num] = node
		}

		node := memo[num]
		degree = max(degree, node.degree)
	}

	res := math.MaxInt32

	for _, node := range memo {
		if node.degree == degree {
			res = min(res, node.endIndex-node.beginIndex+1)
		}
	}
	return res
}
