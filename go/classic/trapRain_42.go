package classic

func trap(height []int) int {
	if height == nil || len(height) == 0 {
		return 0
	}
	left, right := make([]int, len(height)), make([]int, len(height))

	left[0] = height[0]
	for i := 1; i < len(height); i++ {
		left[i] = max(left[i-1], height[i])
	}

	right[len(height)-1] = height[len(height)-1]
	for j := len(height) - 2; j >= 0; j-- {
		right[j] = max(right[j+1], height[j])
	}
	res := 0
	for i := 0; i < len(height); i++ {
		res += min(left[i], right[i]) - height[i]
	}

	return res
}
