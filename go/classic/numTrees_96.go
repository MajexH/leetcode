package classic

// numsTrees 要形成二叉搜索树
// 左边的节点要小于根节点 右边的节点要大于根节点
func numTrees(n int) int {
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 1; i <= n; i++ {
		for j := 1; j <= i; j++ {
			dp[i] += dp[j-1] * dp[i-j]
		}
	}

	return dp[n]
}
