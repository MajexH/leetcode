package classic

func increasingTriplet(nums []int) bool {
	if len(nums) == 0 {
		return false
	}
	mins, maxes := make([]int, len(nums)), make([]int, len(nums))
	mins[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		mins[i] = min(mins[i-1], nums[i])
	}

	maxes[len(nums)-1] = nums[len(nums)-1]
	for i := len(nums) - 2; i >= 0; i-- {
		maxes[i] = max(maxes[i+1], nums[i])
	}

	for i, num := range nums {
		if num > mins[i] && num < maxes[i] {
			return true
		}
	}
	return false
}
