package classic

// 这道题题干 要求 stones 两两相撞 剩下一块儿 为剩下的石头 最小能形成的重量
// 其实就是问是否能够形成相等的两部分 因为相等的话 最后形成的石头 为 0
func lastStoneWeightII(stones []int) int {
	sum := getStonesSum(stones)
	// dp[i][j] 表示前 i 个能否形成 何为 j
	dp := make([][]bool, len(stones)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, sum/2+1)
		// 合为0一定可以
		dp[i][0] = true
	}
	maxSum := 0
	for i := 1; i <= len(stones); i++ {
		for j := 1; j <= sum/2; j++ {
			// 因为表示的前 i 能不能形成 j 所以 i-1 能形成的话 也是可以的
			dp[i][j] = dp[i][j] || dp[i-1][j]
			if j >= stones[i-1] {
				dp[i][j] = dp[i][j] || dp[i-1][j-stones[i-1]]
			}
			if dp[i][j] {
				maxSum = max(maxSum, j)
			}
		}
	}
	return sum - 2*maxSum
}

func getStonesSum(stones []int) (sum int) {
	for _, w := range stones {
		sum += w
	}
	return
}
