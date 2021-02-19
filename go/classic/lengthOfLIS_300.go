package classic

func lengthOfLIS(nums []int) int {
	// dp[i] 表示 nums[i] 结尾的最长的递增子序列长度为多少
	dp := make([]int, len(nums))
	// 初始化 一个数字肯定是递增的
	for i := 0; i < len(nums); i++ {
		dp[i] = 1
	}
	res := 0
	for i, num := range nums {
		for j := 0; j < i; j++ {
			if num > nums[j] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		res = max(res, dp[i])
	}
	return res
}
