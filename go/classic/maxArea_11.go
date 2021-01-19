package classic

func maxArea(height []int) int {
	res := 0

	i, j := 0, len(height)-1

	for i < j {
		res = max(res, min(height[i], height[j])*(j-i))
		if height[i] > height[j] {
			j--
		} else {
			i++
		}
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
