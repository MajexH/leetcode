package jzoffer

import "math"

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	res := math.MinInt32
	for i, num := range nums {
		if i == 0 {
			dp[i] = num
			res = max(res, dp[i])
			continue
		}

		if dp[i-1] < 0 {
			dp[i] = num
		} else {
			dp[i] = dp[i-1] + num
		}
		res = max(res, dp[i])
	}
	return res
}
