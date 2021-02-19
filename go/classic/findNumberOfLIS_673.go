package classic

// 找到 LIS 对应的长度的子序列有多少个
func findNumberOfLIS(nums []int) int {
	// 保存 nums[i] 结尾的 LIS 的长度
	dp := make([]int, len(nums))
	// 保存 nums[i] 结尾的 LIS 的最长 LIS 的长度
	counts := make([]int, len(nums))

	for i := 0; i < len(dp); i++ {
		dp[i] = 1
		counts[i] = 1
	}

	maxLen := 0
	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if dp[i] <= dp[j] {
					// 说明 j 的长度比这个长
					dp[i] = dp[j] + 1
					counts[i] = counts[j]
				} else if dp[j]+1 == dp[i] {
					// 长度相差 1 说明这个时候 counts 要 + 上 j 的
					counts[i] += counts[j]
				}
			}
		}
		maxLen = max(maxLen, dp[i])
	}

	res := 0
	for i, count := range counts {
		if maxLen == dp[i] {
			res += count
		}
	}
	return res
}
