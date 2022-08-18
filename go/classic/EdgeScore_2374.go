package classic

// 题目的统计入度上的数据
func edgeScore(edges []int) int {
	inDegrees := make([]int, len(edges))

	for index, val := range edges {
		inDegrees[val] += index
	}

	res := 0
	valMax := 0
	for index, val := range inDegrees {
		if val > valMax {
			res = index
			valMax = val
		}
	}
	return res
}
