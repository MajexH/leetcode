package classic

import "math"

func maxSubArray(nums []int) int {
	dp := make([]int, len(nums))

	res := math.MinInt32
	for i, num := range nums {
		if i == 0 {
			dp[i] = num
		} else if dp[i-1] <= 0 {
			dp[i] = num
		} else {
			dp[i] = dp[i-1] + num
		}
		res = max(dp[i], res)
	}
	return res
}
