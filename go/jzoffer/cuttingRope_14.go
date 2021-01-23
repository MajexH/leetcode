package jzoffer

// cuttingRope 动态规划 剪绳子成 m 段 找到每段长度乘起来的最大结果
func cuttingRope(n int) int {
	// dp[i] 表示长度为 i 的绳子的能够剪成的最大乘积的结果
	dp := make([]int, n)

	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			dp[i] = max(dp[i], (j-i)*max(dp[j], n-j))
		}
	}

	return dp[0]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
