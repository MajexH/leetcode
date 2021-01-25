package classic

func canJump1(nums []int) bool {
	// dp[i] 表示从0开始 能够跳到
	dp := make([]bool, len(nums))
	// 初试条件
	dp[0] = true

	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if dp[j] && nums[j]+j >= i {
				dp[i] = true
			}
			if dp[i] {
				break
			}
		}
	}
	return dp[len(nums)-1]
}

func canJump(nums []int) bool {
	rightMost := 0
	for i, num := range nums {
		// 如果当前的下标大于 rightMost 说明这个点是无法到达的 直接返回 false 即可
		if i > rightMost {
			return false
		}
		rightMost = max(rightMost, i+num)
		if rightMost >= len(nums)-1 {
			return true
		}
	}
	return false
}
